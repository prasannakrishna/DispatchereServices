/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.util.*;
import java.io.*;

/**
 ** This class is used by the MaintQueryEJB class when returning the results of
 * an executeSelect call to the client.
 ** <P>
 ** If the select was succesfull the results of the select are contained in this
 * class. If the select was unsucessfull an error code will be contained and no
 * results can be accessed.
 ** 
 * <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       11/11/99  SAC DCS     WEB4402   Initial release
** dcs 740   29/08/02  JH  DCS     NEW6253   Migrating to app server
** 2010.2-b  28/05/10  RMD DCS     DSP1184   Add column names to the result set
 ** </PRE>
 **
 */
public class ServerResultSet implements Serializable {
	private Vector<Vector<String>> m_vctResults;
	private Vector<String> m_vctColumns;
	private String m_strErrorCode;
	private int m_noOfRows;
	private int m_noOfCols;

	/**
	 ** Creates an instance of the ServerResultSet with the results of the query.
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** 1.0       13/10/99  SAC DCS     WEB4402   Initial release
	** 2010.2-b  28/05/10  RMD DCS     DSP1184   Add column names to the result set
	 ** </PRE>
	 **
	 ** @param p_vctResultSet
	 *            Rows returned from an sql statement.
	 ** @param p_vctColumns
	 *            Column identifiers returned from an sql statement.
	 **
	 */
	public ServerResultSet(Vector p_vctResultSet, Vector p_vctColumns) {
		m_vctResults = p_vctResultSet;
		m_vctColumns = p_vctColumns;
		m_strErrorCode = "";

		if (p_vctResultSet == null) {
			m_noOfRows = 0;
		} else {
			m_noOfRows = p_vctResultSet.size();
		}

		if (p_vctColumns == null) {
			m_noOfCols = 0;
		} else {
			m_noOfCols = p_vctColumns.size();
		}
	}

	/**
	 ** Creates an instance of the ServerResultSet with an error message and no
	 * results
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** 1.0       13/10/99  SAC DCS     WEB4402   Initial release
	** 2010.2-b  28/05/10  RMD DCS     DSP1184   Add column names to the result set
	 ** </PRE>
	 ** 
	 * @param p_errMessage
	 *            Error code, this can be translated into a message.
	 */
	public ServerResultSet(String p_errMessage) {
		this(null, null);
		m_strErrorCode = p_errMessage;
	}

	/**
	 * @return Vector containing the result set. Note that this vector will contain
	 *         null values for empty column values
	 */
	public Vector<Vector<String>> getResults() {
		return m_vctResults;
	}

	/**
	 * @return Vector containing the column identifiers. The identifiers will be in
	 *         the same order as the results returned by {@link #getResults()}
	 */
	public Vector<String> getResultsColumns() {
		return m_vctColumns;
	}

	/**
	 * @return The number of rows contained in the results
	 */
	public int getRowCount() {
		return m_noOfRows;
	}

	/**
	 * @return The number of columns contained in the results. This will be set even
	 *         if there are no rows in the results
	 */
	public int getColumnCount() {
		return m_noOfCols;
	}

	/**
	 * Get a string value from the results at the specified row and column name.
	 * <P>
	 * 
	 * @param p_row
	 *            Index of the row to get value from
	 * @param p_columnIdentifier
	 *            Identifier of the column to get value from
	 *            <P>
	 * @return The value at the specified row and column. Note that a null will
	 *         never be returned only a zero length string.
	 */
	public String getValueAt(int p_row, String p_columnIdentifier) {
		String l_strValue = m_vctResults.get(p_row).get(m_vctColumns.indexOf(p_columnIdentifier.toLowerCase()));
		if (l_strValue == null) {
			return "";
		}

		return l_strValue;
	}

	/**
	 * @return Whether the select command was executed successfully.
	 */
	public boolean success() {
		return m_strErrorCode.equals("");
	}

	/**
	 * @return String which is the error code if the select was not successfull
	 */
	public String getErrorMessage() {
		return m_strErrorCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		StringBuffer l_bufObject = new StringBuffer("[" + this.getClass().getName() + "@");

		l_bufObject.append("ErrorCode:" + m_strErrorCode + ":");
		l_bufObject.append("NoOfRows:" + m_noOfRows + "]");
		l_bufObject.append("NoOfCols:" + m_noOfCols + "]");

		return l_bufObject.toString();
	}

}
