package com.by.dispatcherserver.dispatcherService.dcsserver;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import com.by.dispatcherserver.dispatcherService.dcslibrary.BindVariableData;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSResponse;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ExecuteSelectRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ServerResultSet;

public class ConnectionActions {
	Connection m_connection;

	public ConnectionActions(Object m_sessionContext, Connection m_connection, Object m_logger) {
		// TODO Auto-generated constructor stub
		this.m_connection = m_connection;
	}

	public DCSResponse executeSelect(DCSRequest p_request) {
		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ConnectionActions.executeSelect() - start");
		DCSResponse l_response = null;

		// ServerResultSet executeSelect(ArrayList)
		try {
			// Get parameters
			ExecuteSelectRequest l_executeRequest = (ExecuteSelectRequest) p_request.m_object;

			// Execute select statement
			ServerResultSet l_serverResultSet = executeSelectBody(l_executeRequest, p_request);

			// Create response
			l_response = new DCSResponse();
			l_response.m_bSuccess = true;
			l_response.m_object = l_serverResultSet;
		} catch (Exception p_e) {
			// m_logger.outputStackTraceInfo(p_e);
			// l_response = ClientEJBBean.createExceptionResponse("WSM01013", p_e);

			// if (p_request.m_nRequestAction <= c_EJBReqTypeOperation) {
			// Don't rollback web service request caused error
			// m_sessionContext.setRollbackOnly();
			// }
		}

		return l_response;
	}

	protected ServerResultSet executeSelectBody(ExecuteSelectRequest p_executeRequest, DCSRequest p_request)
			throws Exception {
		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ConnectionActions.executeSelectBody() - start");
		ServerResultSet l_serverResultSet = null;
		Statement l_statement = null;
		PreparedStatement l_prepared = null;
		ResultSet l_rset = null;
		String l_strSql = null;

		try {
			// Get select statement parameters
			l_strSql = p_executeRequest.getSQL();
			int l_nNumRows = p_executeRequest.getMaxRows();
			int l_nBlobColumn = p_executeRequest.getBlobColumn();
			BindVariableData l_bindVariables = p_executeRequest.getBindVariables();

			// Execute select statement
			l_statement = m_connection.createStatement();
			// m_logger.outputTraceInfo(c_LoggingLevelDebug,
			// "ConnectionActions.executeSelectBody() - running sql stmt: " + l_strSql);
			Vector l_vctResults = null;

			if (l_bindVariables == null) {
				// Don't use bind variables
				l_rset = l_statement.executeQuery(l_strSql);
			} else {
				// Use bind variables provided
				l_prepared = m_connection.prepareStatement(l_strSql);

				for (int l_nIndex = 0; l_nIndex < l_bindVariables.size(); l_nIndex++) {
					if (l_bindVariables.getType(l_nIndex) == BindVariableData.c_DataTypeLong) {
						l_prepared.setLong(l_nIndex + 1, Long.parseLong(l_bindVariables.getValue(l_nIndex)));
					} else if (l_bindVariables.getType(l_nIndex) == BindVariableData.c_DataTypeDouble) {
						l_prepared.setDouble(l_nIndex + 1, Double.parseDouble(l_bindVariables.getValue(l_nIndex)));
					} else {
						l_prepared.setString(l_nIndex + 1, l_bindVariables.getValue(l_nIndex));
					}
				}

				l_rset = l_prepared.executeQuery();
			}

			if (l_nBlobColumn == -1) {
				// Use the quickest method of getting data
				l_vctResults = processResults(l_rset, l_nNumRows);
			} else {
				// Use the slower method to get blob data
				l_vctResults = processResults(l_rset, l_nNumRows, l_nBlobColumn);
			}

			// Work out the column names for the results
			ResultSetMetaData l_metaData = l_rset.getMetaData();
			Vector l_vctColumns = new Vector();

			for (int i = 0; i < l_metaData.getColumnCount(); i++) {
				String l_strName = l_metaData.getColumnName(i + 1);
				l_vctColumns.add(l_strName == null ? "" : l_strName.toLowerCase());
			}

			l_rset.close();

			if (l_prepared != null) {
				l_prepared.close();
			}

			l_statement.close();

			// Get result set to return
			l_serverResultSet = new ServerResultSet(l_vctResults, l_vctColumns);
		} catch (Exception p_e) {
			/*
			 * m_logger.showSqlStatement(p_e, l_strSql);
			 * ClientEJBBean.closeResultSet(l_rset);
			 * ClientEJBBean.closePreparedStatement(l_prepared);
			 * ClientEJBBean.closeStatement(l_statement);
			 * 
			 * if (p_request.m_nRequestAction <= c_EJBReqTypeOperation) { // Don't rollback
			 * web service request caused error m_sessionContext.setRollbackOnly(); }
			 */

			throw p_e;
		}

		return l_serverResultSet;
	}

	private Vector processResults(ResultSet p_rset, int p_nNumRows) throws Exception {
		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ConnectionActions.processResults() - start");
		Vector l_vctResults = new Vector();

		// Work out the number of columns using the meta data
		int l_nNumColumns = p_rset.getMetaData().getColumnCount();

		// Outer loop to process each row
		for (int l_nRow = 0; ((l_nRow < p_nNumRows) && (p_rset.next() != false)); l_nRow++) {
			Vector l_vctTemp = new Vector(l_nNumColumns);

			// Inner loop to process each column
			for (int l_nColumn = 1; l_nColumn <= l_nNumColumns; l_nColumn++) {
				Object l_objColValue = p_rset.getObject(l_nColumn);

				if (l_objColValue instanceof Clob) {
					Clob l_clob = (Clob) l_objColValue;

					long l_clobLength = l_clob.length();
					String l_strClobString = "";

					int l_maxChars = 2147483647; // is the largest int java handles

					if (l_clobLength <= l_maxChars) {
						// is clob length less then the biggest int Java can handle
						l_strClobString = l_clob.getSubString(1, (int) l_clobLength);
					} else {
						long l_startpos = 1;

						while (true) {
							l_strClobString += l_clob.getSubString(l_startpos, l_maxChars);

							l_startpos += (l_maxChars + 1);

							if (l_startpos > l_clobLength) {
								break;
							}
						}
					}

					l_vctTemp.addElement(l_strClobString);
				} else {
					l_vctTemp.addElement(p_rset.getString(l_nColumn));
				}
			}

			l_vctResults.addElement(l_vctTemp);
		}

		return l_vctResults;
	}

	/**
	 **
	 ** Process results from query - containing a blob column. <BR>
	 * <BR>
	 ** 
	 * <PRE>
	** Release   Date     By  Proj   Ref      Description
	** --------- -------- --- ------ -------- --------------------------------------
	** dcs 740   27/09/02 JH  DCS    NEW6253  Migrating to app server
	** 2005.2-b  28/06/05 RMD dlxdsp NEW7703  Remove need for column count
	** 2006.1.0  25/11/05 RMD DCS    NEW7942  Allow for null blobs
	** 2010.1.0  10/03/10 JH  DCS    DSP3248  Don't set size of new vector
	 ** </PRE>
	 ** 
	 * @param p_rset
	 *            Result set.
	 ** @param p_nNumRows
	 *            Number of rows.
	 ** @param p_nBlobColumn
	 *            Number of blob column.
	 **
	 ** @return Vector containing results.
	 **
	 ** @throws Exception
	 *             Exception.
	 */
	private Vector processResults(ResultSet p_rset, int p_nNumRows, int p_nBlobColumn) throws Exception {
		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ConnectionActions.processResults() - start");
		Vector l_vctResults = new Vector();
		byte[] l_arrBlob = null;

		// Work out the number of columns using the meta data
		int l_nNumColumns = p_rset.getMetaData().getColumnCount();

		// Outer loop to process each row
		for (int l_nRow = 0; ((l_nRow < p_nNumRows) && (p_rset.next() != false)); l_nRow++) {
			Vector l_vctTemp = new Vector(l_nNumColumns);

			// Inner loop to process each column
			for (int l_nColumn = 1; l_nColumn <= l_nNumColumns; l_nColumn++) {
				if (l_nColumn == p_nBlobColumn) {
					// Get the blob handle and then materialize the data
					Blob l_blob = p_rset.getBlob(l_nColumn);
					if (l_blob != null) {
						l_arrBlob = l_blob.getBytes(1L, (int) l_blob.length());
						l_vctTemp.addElement(l_arrBlob);
					} else {
						l_vctTemp.addElement(null);
					}
				} else {
					l_vctTemp.addElement(p_rset.getString(l_nColumn));
				}
			}

			l_vctResults.addElement(l_vctTemp);
		}

		return l_vctResults;
	}

}
