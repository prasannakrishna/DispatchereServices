package com.by.dispatcherserver.dispatcherService.dcsserver;

import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.by.dispatcherserver.dispatcherService.dcslibrary.ClientConstant;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ColumnData;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSResponse;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DatabaseConstant;
import com.by.dispatcherserver.dispatcherService.dcslibrary.GeneralConstant;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ServerExecuteResult;
import com.by.dispatcherserver.dispatcherService.dcslibrary.TransactionState;
import com.by.dispatcherserver.dispatcherService.dcslibrary.UnpackedMessage;

/**
 ** Operation actions for client ejb - i.e. for use once user logged in. The
 ** protected methods in this class should match those in the client code in the
 * ClientEJB class. <BR>
 * <BR>
 ** 
 * <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------------
** dcs 740   27/09/02 JH  DCS    NEW6253  Migrating to app server
** dcs 810   30/06/03 EW  DCS    PDR9042  Maximum number of open cursors exceeded
** dcs 820   20/08/03 RMD DCS    NEW6621  Add executeMultipleOperations
** 2005.1    06/04/05 JH  dlxdsp PDR09540 Web client performance issues
** 2005.1    25/05/05 JH  dlxdsp PDR09572 Web client performance issues
** 2005.2.0  04/10/05 RMD DCS    NEW7454  Add drill down functionality
** 2005.2.1  10/11/05 JH  dlxdsp NEW7955  Porting to oracle 10.2.0.1.0
** 2006.1.0  25/11/05 RMD DCS    NEW7942  Add blob support
** 2006.1.1  20/04/06 JH  DCS    BUG2519  Problem changing password with jboss as 4.0.4
** 2006.1.1  13/04/06 RMD dcs    ENH2253  Fix in executeMultipleOperations
** 2006.1.2  22/06/06 JH  dcs    ENH2773  Add extra password validation
** 2006.2.0  13/09/06 JH  dcs    ENH3072  Add extra password validation
** 2006.2.1  26/10/06 JH  DCS    ENH3221  Web client workstation support
** 2006.2.1  04/12/06 JH  DCS    ENH3363  Encrypt/decrypt web client user passwords
** 2006.2.2  02/02/07 JH  dcs    ENH3479  Add session id to user log/login failure
** 2007.1.0  23/02/07 RMD DCS    ENH3356  Allow error return with no message
** 2007.1.0  26/03/07 JH  dcs    ENH3552  Add icons into web client menu
** 2007.1.2  21/07/07 JH  DCS    DSP1250  Add themes to the web client
** 2007.2.0  10/09/07 JH  DCS    DSP1342  Benchmarking changes
** 2008.1.0  07/04/08 JH  DCS    DSP1716  Fix ora-1460 problem
** 2008.2.1  09/12/08 JH  dcs    DSP2181  Web logic transaction issue
** 2009.1-b  09/01/09 DL  dcs    DSP376   Oracle LDAP Authentication Support
** 2009.2.b  06/04/09 SNP DCS    DSP2403  SCC - Client Java Operations Screens
** 2009.2-b  07/05/09 PC  DCS    DSP2341  Media functionality made generic
** 2009.1.1  28/04/09 JH  dcs    DSP2519  Free up lob temporary space
** 2009.2.0  12/08/09 JH  dcs    DSP2755  System profile password handling
** 2010.1-b  09/11/09 RMD dcs    DSP2486  Allow for batched multiple transactions
** 2010.1.1  30/03/10 EW  DCS    DSP3182  Parent request warning not shown
** 2010.2.0  14/08/10 JH  DCS    DSP2832  Enquirer licencing
** 2011.2.2  16/01/12 JH  dcs    DSP4855  Set users disabled date
** 2012.1.2  02/07/12 JH  DCS    DSP4922  Mobile licencing
** 2013.2-b  21/04/13 JH  DCS    DSP6141  In-store picking functionality
** 2013.2.0  19/11/13 JH  DCS    DSP6006  Porting to oracle 12c
** 2017.1.0  19/06/17 NS  DCS    DSP11541 SIG: MQS screens GUI validation
** 2018.1.0  30/07/18 NS  DCS    DSP12486 Diagnostic request for JBOSS ORA-01461 error 
** 2019.1.0  11/09/19 GS  DCS    DSP13174 Second Order Injection
 ** </PRE>
 */
public class OperationActions implements DatabaseConstant, GeneralConstant, ClientConstant {

	Connection m_connection;

	public OperationActions(Object m_sessionContext, Connection m_connection, Object m_logger) {
		// TODO Auto-generated constructor stub
		this.m_connection = m_connection;

	}

	public DCSResponse executeTransaction(DCSRequest p_request) {
		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "OperationActions.executeTransaction() - start");
		DCSResponse l_response = null;
		CallableStatement l_callable = null;
		String l_strSql = null;
		Boolean l_allowed = true;
		String l_strColumnData = "";
		String l_strMessages = "";
		Vector l_vctMessages = null;
		String l_strPackage = "";
		// ServerExecuteResult executeTransaction(ArrayList)
		try {
			// Get parameters
			List l_listi = (ArrayList) p_request.m_object;
			String l_strSqlStmt = (String) l_listi.get(0);
			String l_strTableName = (String) l_listi.get(1);
			String l_strTransType = (String) l_listi.get(2);
			ColumnData l_columnData = (ColumnData) l_listi.get(3);
			TransactionState l_transaction = (TransactionState) l_listi.get(4);
			String l_strScreenLabel = (String) l_listi.get(5);

			if ((l_strTableName.equals("application_user") == true || l_strTableName.equals("system_profile") == true)
					&& l_strTransType.equals("delete") != true) {
				String l_strUserId = l_columnData.get("user_id");
				String l_strEncrypted = "";
				String l_strPassword = "";

				if (l_strTableName.equals("application_user") == true) {
					l_strEncrypted = l_columnData.get("password");
				} else {
					l_strEncrypted = l_columnData.get("value");
				}

				if (l_strEncrypted.equals("") == false) {
					/*
					 * l_strPassword =
					 * ClientEJBBean.getDecryptedPassword(!p_request.m_bBenchmarkMode,
					 * p_request.m_strSessionId, l_strUserId, l_strEncrypted);
					 */
				}

				if (l_strTableName.equals("application_user") == true) {
					l_columnData.setColumnValue("password", l_strPassword);
				} else {
					l_columnData.setColumnValue("value", l_strPassword);
				}
			}

			if (l_strScreenLabel.isEmpty() == false) {
				// l_allowed = IsMQSOperationAllowed(p_request, l_strScreenLabel,
				// l_strTransType);
			}

			/*
			 * m_logger.outputTraceInfo(c_LoggingLevelInfo, "Function Access allowed=" +
			 * l_allowed + ",l_columnData" + l_columnData.toString()); l_strColumnData =
			 * getColumnData(l_columnData);
			 */

			if (l_allowed) {
				// Execute transaction
				// l_strColumnData = getColumnData(l_columnData);
				ServerExecuteResult l_serverExecuteResult = null;
				l_strPackage = "LibMQS" + l_strTableName;
				boolean m_bSetRollbackOnly = false;
				if (l_transaction == null) {
					l_transaction = new TransactionState();
				}

				/*
				 * if (globalOptionEnabled("MQS_SCR_VAL") &&
				 * (l_strTransType.equalsIgnoreCase(c_UpdateTran) ||
				 * l_strTransType.equalsIgnoreCase(c_DeleteTran))) { l_strSql =
				 * "{ call LibMQSData_Val.DataValidation(?,?,?,?,?,?,?) }"; //
				 * m_logger.outputTraceInfo(c_LoggingLevelDebug, //
				 * "OperationActions.executeTransaction() - running sql stmt validation call : "
				 * // + l_strSql); l_serverExecuteResult =
				 * executeProcessedDataValidation(l_strSql, l_strColumnData, l_strTableName,
				 * "Pre-" + l_strTransType, l_transaction); }
				 */

				if (l_transaction.hasBeenPreProcessed() == false && l_serverExecuteResult == null) {
					l_strSql = "{ call " + l_strPackage + ".Pre" + l_strTransType + "(?,?,?) }";
					l_serverExecuteResult = executeProcessedStmt(l_strSql, l_strColumnData, l_transaction);
					if (l_serverExecuteResult == null) {
						l_transaction.setPreProcessed(true);
					}
				}

				if (l_transaction.hasBeenPreProcessed() == true && l_transaction.hasBeenExecuted() == false) {
					l_strSql = "{ call DBMS_LOB.CREATETEMPORARY(?, TRUE) }";

					// m_logger.outputTraceInfo(c_LoggingLevelDebug,
					// "OperationActions.executeTransaction() - running sql stmt: " + l_strSql);
					l_callable = m_connection.prepareCall(l_strSql);
					l_callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CLOB);
					l_callable.execute();
					Clob l_clob1 = (Clob) l_callable.getObject(1);
					l_clob1.setString(1, l_strColumnData);
					l_callable.close();

					// m_logger.outputTraceInfo(c_LoggingLevelDebug,
					// "OperationActions.executeTransaction() - running sql stmt: " + l_strSql);
					l_callable = m_connection.prepareCall(l_strSql);
					l_callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CLOB);
					l_callable.execute();
					Clob l_clob2 = (Clob) l_callable.getObject(1);
					l_clob2.setString(1, l_strSqlStmt);
					l_callable.close();

					l_strSql = "{ call " + l_strPackage + ".ExecuteTransaction(?,?,?,?,?) }";

					// m_logger.outputTraceInfo(c_LoggingLevelDebug,
					// "OperationActions.executeTransaction() - running sql stmt: " + l_strSql);
					l_callable = m_connection.prepareCall(l_strSql);
					l_callable.setClob(3, l_clob1);
					l_callable.setString(4, l_strTransType.toUpperCase());
					l_callable.setClob(5, l_clob2);
					l_callable.registerOutParameter(1, Types.INTEGER);
					l_callable.registerOutParameter(2, Types.VARCHAR);
					l_callable.execute();

					if (l_callable.getInt(1) == c_MQSError) {
						l_strMessages = l_callable.getString(2);
						// l_vctMessages = packErrorMessage(l_strMessages);
						l_serverExecuteResult = new ServerExecuteResult(c_MQSError, l_vctMessages);
						m_bSetRollbackOnly = true;
					}

					l_callable.close();

					l_strSql = "{ call DBMS_LOB.FREETEMPORARY(?) }";

					// m_logger.outputTraceInfo(c_LoggingLevelDebug,
					// "OperationActions.executeTransaction() - running sql stmt: " + l_strSql);
					l_callable = m_connection.prepareCall(l_strSql);
					l_callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CLOB);
					l_callable.setClob(1, l_clob1);
					l_callable.execute();
					l_callable.close();

					// m_logger.outputTraceInfo(c_LoggingLevelDebug,
					// "OperationActions.executeTransaction() - running sql stmt: " + l_strSql);
					l_callable = m_connection.prepareCall(l_strSql);
					l_callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CLOB);
					l_callable.setClob(1, l_clob2);
					l_callable.execute();
					l_callable.close();

					if (l_serverExecuteResult == null) {
						l_transaction.setExecuteProcessed(true);
					}
				}

				if (l_transaction.hasBeenPreProcessed() == true && l_transaction.hasBeenExecuted() == true
						&& l_transaction.hasBeenPostProcessed() == false) {
					l_strSql = "{ call " + l_strPackage + ".Post" + l_strTransType + "(?,?,?) }";

					l_serverExecuteResult = executeProcessedStmt(l_strSql, l_strColumnData, l_transaction);

					if (l_serverExecuteResult == null) {
						l_serverExecuteResult = new ServerExecuteResult(c_MQSSuccess);
						l_transaction.setPostProcessed(true);
					}
				}
				// m_logger.outputTraceInfo(c_LoggingLevelDebug,
				// "OperationActions.executeTransaction() - running sql stmt l_strTransType : "
				// + l_strTransType);
				/*
				 * if (globalOptionEnabled("MQS_SCR_VAL") &&
				 * (l_strTransType.equalsIgnoreCase(c_InsertTran) ||
				 * l_strTransType.equalsIgnoreCase(c_UpdateTran)) &&
				 * l_transaction.hasBeenPostProcessed() == true) {
				 * 
				 * l_strSql = "{ call LibMQSData_Val.DataValidation(?,?,?,?,?,?,?) }";
				 * 
				 * //m_logger.outputTraceInfo(c_LoggingLevelDebug,
				 * //"OperationActions.executeTransaction() - running sql stmt validation call : "
				 * + l_strSql); l_serverExecuteResult = executeProcessedDataValidation(l_strSql,
				 * l_strColumnData, l_strTableName, "Post-" + l_strTransType, l_transaction);
				 * 
				 * if (l_serverExecuteResult == null) { l_serverExecuteResult = new
				 * ServerExecuteResult(c_MQSSuccess); l_transaction.setValProcessed(true); }
				 * 
				 * }
				 */

				if (m_bSetRollbackOnly == true) {
					// m_sessionContext.setRollbackOnly();
				}

				// Create response
				l_response = new DCSResponse();
				l_response.m_bSuccess = true;
				l_response.m_object = l_serverExecuteResult;
			} else {

				// m_logger.outputTraceInfo(c_LoggingLevelDebug, "IsMQSOperationAllowed () -
				// returned false");
				l_response = new DCSResponse();
				l_strMessages = "WCM01410;" + l_strColumnData.toString();
				// l_vctMessages = packErrorMessage(l_strMessages);
				l_response.m_bSuccess = true;
				ServerExecuteResult l_serverExecuteResult = new ServerExecuteResult(c_MQSNoPrivilege, l_vctMessages);
				l_response.m_object = l_serverExecuteResult;
			}
		} catch (Exception p_e) {
			// m_logger.showSqlStatement(p_e, l_strSql);
			// l_response = ClientEJBBean.createExceptionResponse("WSM01032", p_e);
			// ClientEJBBean.closeCallableStatement(l_callable);
			// m_sessionContext.setRollbackOnly();
		}

		return l_response;
	}

	private ServerExecuteResult executeProcessedStmt(String p_strSql, String p_strColumnData,
			TransactionState p_transaction) throws Exception {
		//m_logger.outputTraceInfo(c_LoggingLevelInfo, "OperationActions.executeProcessedStmt() - start");
		ServerExecuteResult l_serverExecuteResult = null;
		CallableStatement l_callable = null;
		String l_strMessage = null;
		int l_nStatus = 0;

		try {
			String l_strSql = "{ call DBMS_LOB.CREATETEMPORARY(?, TRUE) }";

			//m_logger.outputTraceInfo(c_LoggingLevelDebug,
					//"OperationActions.executeProcessedStmt() - running sql stmt: " + l_strSql);
			l_callable = m_connection.prepareCall(l_strSql);
			l_callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CLOB);
			l_callable.execute();
			Clob l_clob = (Clob) l_callable.getObject(1);
			l_clob.setString(1, p_strColumnData);
			l_callable.close();

			//m_logger.outputTraceInfo(c_LoggingLevelDebug,
					//"OperationActions.executeProcessedStmt() - running sql stmt: " + p_strSql);
			l_callable = m_connection.prepareCall(p_strSql);
			l_callable.setClob(3, l_clob);
			l_callable.registerOutParameter(1, Types.INTEGER);
			l_callable.registerOutParameter(2, Types.VARCHAR);
			l_callable.execute();

			l_nStatus = l_callable.getInt(1);

			if (l_nStatus != c_MQSSuccess) {
				l_strMessage = l_callable.getString(2);

				if (l_nStatus == c_MQSError) {
					l_serverExecuteResult = new ServerExecuteResult(c_MQSError, /*packErrorMessage(l_strMessage)*/ new Vector<>());
				} else {
					// Check what states have been processed, then return if any have not
					// been processed, and add them to the list of processed states
					UnpackedMessage l_unpackedMessage = new UnpackedMessage(l_strMessage);

					Vector l_vctUnprocessedStates = l_unpackedMessage.getUnprocessedStates(p_transaction.getStates());

					if (l_vctUnprocessedStates.size() != 0) {
						p_transaction.mergeStates(l_unpackedMessage.getStates());

						l_serverExecuteResult = new ServerExecuteResult(l_nStatus, l_vctUnprocessedStates,
								p_transaction);
					}
				}
			}

			l_callable.close();

			l_strSql = "{ call DBMS_LOB.FREETEMPORARY(?) }";

			//m_logger.outputTraceInfo(c_LoggingLevelDebug,
					//"OperationActions.executeProcessedStmt() - running sql stmt: " + l_strSql);
			l_callable = m_connection.prepareCall(l_strSql);
			l_callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CLOB);
			l_callable.setClob(1, l_clob);
			l_callable.execute();
			l_callable.close();

			if (l_serverExecuteResult != null && l_serverExecuteResult.getStatus() != c_MQSCommitWarning) {
				//m_bSetRollbackOnly = true;
			}
		} catch (Exception p_e) {
			//ClientEJBBean.closeCallableStatement(l_callable);
			throw p_e;
		}

		return l_serverExecuteResult;
	}

	private boolean globalOptionEnabled(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
