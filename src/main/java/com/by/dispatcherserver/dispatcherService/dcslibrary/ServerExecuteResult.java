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
 **
 ** This class returns the result of an execute statement call on the MaintQuery
 ** EJB. It also contains any warning messages, error messages that were
 * generated as a result of the execute statement call. <BR>
 * <BR>
 ** 
 * <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       14/12/99  SAC DCS     WEB4402   Initial Release
** dcs 740   29/08/02  JH  DCS     NEW6253   Migrating to app server
** dcs 820   20/08/03  RMD DCS     NEW6621   Add executeMultipleOperations
** dcs 9.0.0 19/01/05  RMD dcs     NEW7578   Added getColumnValue
 ** </PRE>
 **
 */
public class ServerExecuteResult implements Serializable {
	private long m_nStatus;
	private Vector m_vctMessageInfo;
	private TransactionState m_transaction;

	/**
	 **
	 ** Constructs a ServerExecuteResult class with a status, messages and a
	 ** transaction id. <BR>
	 * <BR>
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** 1.0       14/12/99  SAC DCS     WEB4402   Initial Release
	 ** </PRE>
	 **
	 ** @param p_nStatus
	 *            The status of the execute, successful, warning or error.
	 ** @param p_vctMessageInfo
	 *            A vector containing the returned message information.
	 ** @param p_transaction
	 *            The transaction.
	 **
	 */
	public ServerExecuteResult(long p_nStatus, Vector p_vctMessageInfo, TransactionState p_transaction) {
		m_nStatus = p_nStatus;
		m_vctMessageInfo = p_vctMessageInfo;
		m_transaction = p_transaction;
	}

	/**
	 **
	 ** Constructs a ServerExecuteResult class with a status, messages but no
	 ** transaction id. <BR>
	 * <BR>
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** 1.0       14/12/99  SAC DCS     WEB4402   Initial Release
	 ** </PRE>
	 **
	 ** @param p_nStatus
	 *            The status of the execute, successful, warning or error.
	 ** @param p_vctMessageInfo
	 *            A vector containing the returned message information.
	 **
	 */
	public ServerExecuteResult(long p_nStatus, Vector p_vctMessageInfo) {
		this(p_nStatus, p_vctMessageInfo, null);
	}

	/**
	 **
	 ** Constructs a class ServerExecuteResult with just a status and no messages.
	 ** This should only be used when the executeStatement method call execucted
	 ** successfully. So there are no error or warning messages. <BR>
	 * <BR>
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** 1.0       14/12/99  SAC DCS     WEB4402   Initial Release
	 ** </PRE>
	 **
	 ** @param p_nStatus
	 *            The status of the execute, successfull, warning or error.
	 **
	 */
	public ServerExecuteResult(long p_nStatus) {
		this(p_nStatus, new Vector(), null);
	}

	/**
	 **
	 ** Constructs a class ServerExecuteResult with just a status a transaction and
	 * no messages. This should only be used when the executeStatement method call
	 * execucted successfully. So there are no error or warning messages. <BR>
	 * <BR>
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** dcs 820   20/08/03  RMD DCS     NEW6621   Add executeMultipleOperations
	 ** </PRE>
	 **
	 ** @param p_nStatus
	 *            The status of the execute, successfull, warning or error.
	 ** @param p_transaction
	 *            The transaction.
	 **
	 */
	public ServerExecuteResult(long p_nStatus, TransactionState p_transaction) {
		this(p_nStatus, new Vector(), p_transaction);
	}

	/**
	 ** @return Status of the execute statement, c_MQSError, c_MQSWarning or
	 *         c_MQSSuccess.
	 */
	public long getStatus() {
		return m_nStatus;
	}

	/**
	 ** @return Vector of MessageInfo Objects.
	 */
	public Vector getMessageInfo() {
		return m_vctMessageInfo;
	}

	/**
	 ** This method will search the messages for the column name and return the first
	 * column value set for this column name. If this column is not returned in the
	 * messages null will be returned.
	 ** 
	 * @param p_strColumnName
	 *            The column name to get the value for
	 ** @return Column Value or null.
	 */
	public String getColumnValue(String p_strColumnName) {
		/*Iterator l_itrMessages = m_vctMessageInfo.iterator();
		while (l_itrMessages.hasNext()) {
			MessageInfo l_msgInfo = (MessageInfo) l_itrMessages.next();
			if (l_msgInfo.getColumnName().equals(p_strColumnName)) {
				return l_msgInfo.getColumnValue();
			}
		}*/

		// Column not found
		return null;
	}

	/**
	 ** @return The transaction Id.
	 */
	public TransactionState getTransactionState() {
		return m_transaction;
	}

	/**
	 **
	 ** Returns a string representation of this object, and all its data. The first
	 ** part of the string is the objects tyep followed by a @ and then the data.
	 ** <BR>
	 * <BR>
	 ** 
	 * <PRE>
	** Release   Date      By  Proj    Ref       Description
	** --------- --------  --- ------  --------  --------------------------------
	** 1.0       23/03/00  SAC DCS     WEB4402   Initial release
	 ** </PRE>
	 **
	 ** @return A string representation of this object.
	 **
	 */
	public String toString() {
		StringBuffer l_bufObject = new StringBuffer("[" + this.getClass().getName() + "@");

		l_bufObject.append("Status:" + m_nStatus + ":");
		l_bufObject.append("MessageInfoNames:" + m_vctMessageInfo.toString() + "]");

		return l_bufObject.toString();
	}
}
