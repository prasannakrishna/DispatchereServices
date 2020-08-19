/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.io.*;

/**
**
** This class holds the objects required to execute an operation for
** a specific package and procedure.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2006.1.0  25/11/05  RMD DCS     NEW7942   Add blob column data
** </PRE>
**
*/
public class ExecuteOperationRequest implements Serializable
{
  private String m_strPackage = "";
  private String m_strAction = "";
  private ColumnData m_columnData = null;
  private ServerExecuteResult m_serverExecuteResult = null;
  private byte[] m_blobData = null;

/**
**
** Constructs a ExecuteOperationRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** </PRE>
**
** @param p_strPackage The name of the package to execute.
** @param p_strAction The action in the package that has pre and post methods.
** @param p_columnData The column data for the operation
**
*/
  public ExecuteOperationRequest(String p_strPackage,
                                 String p_strAction,
                                 ColumnData p_columnData)
  {
    m_strPackage = p_strPackage;
    m_strAction = p_strAction;
    m_columnData = p_columnData;
  }

/**
**
** Constructs a ExecuteOperationRequest class with the required objects.
** <P>
** Note the blob data will be stored in the web_trans_blob table for use
** by the stored procedure.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** </PRE>
**
** @param p_strPackage The name of the package to execute.
** @param p_strAction The action in the package that has pre and post methods.
** @param p_columnData The column data for the operation
** @param p_blobData Blob column data for this operation
**
*/
  public ExecuteOperationRequest(String p_strPackage,
                                 String p_strAction,
                                 ColumnData p_columnData,
                                 byte[] p_blobData)
  {
    m_strPackage = p_strPackage;
    m_strAction = p_strAction;
    m_columnData = p_columnData;
    m_blobData = p_blobData;
  }  

/**
** @return Package to execute the operation for.
*/
  public String getPackage()
  {
    return m_strPackage;
  }

/**
** @return Action to be executed
*/
  public String getAction()
  {
    return m_strAction;
  }

/**
** @return Column data for the operation
*/
  public ColumnData getColumnData()
  {
    return m_columnData;
  }

/**
** @param p_columnData column data for the operation
*/
  public void setColumnData(ColumnData p_columnData)
  {
    m_columnData = p_columnData;
  }

/**
** @return True if the request has blob data defined
*/
  public boolean hasBlobData()
  {
    return (m_blobData != null);
  }

/**
** @return The blob data for the operation
*/
  public byte[] getBlobData()
  {
    return m_blobData;
  }
  
/**
** @param p_blobData The blob data for the operation
*/
  public void setBlobData(byte[] p_blobData)
  {
    m_blobData = p_blobData;
  }  
  
/**
** @return The server execute result.
*/
  public ServerExecuteResult getServerExecuteResult()
  {
    return m_serverExecuteResult;
  }

/**
** @param p_serverExecuteResult server execute result.
*/
  public void setServerExecuteResult(ServerExecuteResult p_serverExecuteResult)
  {
    m_serverExecuteResult = p_serverExecuteResult;
  }

/**
** Resets the processed flags for a transaction state if it exists.
*/
  public void resetTransactionProcessedFlags()
  {
    if (m_serverExecuteResult != null)
    {
      TransactionState l_transaction = m_serverExecuteResult.getTransactionState();
      if (l_transaction != null)
      {
        l_transaction.setPreProcessed(false);
        l_transaction.setExecuteProcessed(false);
        l_transaction.setPostProcessed(false);
      }
    }
  }

/**
**
** Returns a string representation of this object, and all its data. The first
** part of the string is the objects tyep followed by a @ and then the data.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** </PRE>
**
** @return A string representation of this object.
**
*/
  public String toString()
  {
    StringBuffer l_bufObject = new StringBuffer("[" + this.getClass().getName() + "@");

    l_bufObject.append("Package:" + m_strPackage + ":");
    l_bufObject.append("Action:" + m_strAction + ":");
    l_bufObject.append("Column Data:" + m_columnData.toString() + ":");

    return l_bufObject.toString();
  }
}


