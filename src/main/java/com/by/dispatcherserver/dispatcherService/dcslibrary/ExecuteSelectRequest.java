/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.io.*;

/**
** This class holds the objects required to execute a select statement.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2005.2-b  28/06/05  RMD DCS     NEW7703   Remove num cols/persistent
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
*/
public class ExecuteSelectRequest implements Serializable
{
  private String m_strSql;
  private int m_nMaxRows;
  private int m_nBlobColumn;
  private BindVariableData m_bindVariables;
  
/**
** Constructs an ExecuteSelectRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
** @param p_strSql The sql statement to execute
** @param p_nMaxRows The maximum number of rows required
*/
  public ExecuteSelectRequest(String p_strSql,
      int p_nMaxRows)
  {
    this(p_strSql, p_nMaxRows, -1, null);    
  }

/**
** Constructs an ExecuteSelectRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
** @param p_strSql The sql statement to execute
** @param p_nMaxRows The maximum number of rows required
** @param p_nBlobColumn The column number that is a blob (starts at 1 not 0)
*/
  public ExecuteSelectRequest(String p_strSql,
      int p_nMaxRows, 
      int p_nBlobColumn)
  {
    this(p_strSql, p_nMaxRows, p_nBlobColumn, null);  
  }

/**
** Constructs an ExecuteSelectRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
** @param p_strSql The sql statement to execute
** @param p_nMaxRows The maximum number of rows required
** @param p_bindVariables Bind variable data
*/
  public ExecuteSelectRequest(String p_strSql,
      int p_nMaxRows, 
      BindVariableData p_bindVariables)
  {
    this(p_strSql, p_nMaxRows, -1, p_bindVariables);  
  }

/**
** Constructs an ExecuteSelectRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
** @param p_strSql The sql statement to execute
** @param p_nMaxRows The maximum number of rows required
** @param p_nBlobColumn The column number that is a blob (starts at 1 not 0)
** @param p_bindVariables Bind variable data
*/
  public ExecuteSelectRequest(String p_strSql,
      int p_nMaxRows, 
      int p_nBlobColumn,
      BindVariableData p_bindVariables)
  {
    m_strSql = p_strSql;
    m_nMaxRows = p_nMaxRows;    
    m_nBlobColumn = p_nBlobColumn;    
    m_bindVariables = p_bindVariables;
  }
  
/**
** Constructs a ExecuteSelectRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
**
** @param p_strSql The sql statement to execute
** @param p_nNumColumns The number of columns in the select
** @param p_nMaxRows The maximum number of rows required
** @param p_bPersistent Whether the query is persistent or not
** @param p_nBlobColumn The column number that is a blob (starts at 1 not 0)
**
** @deprecated Method is redundant as p_nNumColumns and p_bPersistent not used
*/
  public ExecuteSelectRequest(String p_strSql,
                              int p_nNumColumns,
                              int p_nMaxRows,
                              boolean p_bPersistent,
                              int p_nBlobColumn)
  {
    this(p_strSql, p_nMaxRows, p_nBlobColumn, null);  
  }
    
/**
** Constructs a ExecuteSelectRequest class with the required objects.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   19/08/03  RMD DCS     NEW6621   Initial Version
** 2009.2-b  15/07/09  JH  dcs     DSP2683   Add bind variable support
** </PRE>
**
** @param p_strSql The sql statement to execute
** @param p_nNumColumns The number of columns in the select
** @param p_nMaxRows The maximum number of rows required
** @param p_bPersistent Whether the query is persistent or not
** @param p_nBlobColumn The column number that is a blob (starts at 1 not 0)
** @param p_bindVariables Bind variable data
**
** @deprecated Method is redundant as p_nNumColumns and p_bPersistent not used
*/
  public ExecuteSelectRequest(String p_strSql,
                              int p_nNumColumns,
                              int p_nMaxRows,
                              boolean p_bPersistent,
                              int p_nBlobColumn,
                              BindVariableData p_bindVariables)
  {
    this(p_strSql, p_nMaxRows, p_nBlobColumn, p_bindVariables);  
  }

/**
** @return The sql statement to execute
*/
  public String getSQL()
  {
    return m_strSql;
  }

/**
** @return Maximum number of rows to select
*/
  public int getMaxRows()
  {
    return m_nMaxRows;
  }

/**
** @return Column number that is a blob (starts at 1 not 0)
*/
  public int getBlobColumn()
  {
    return m_nBlobColumn;
  }

  /**
  ** @return Bind variable data
  */
    public BindVariableData getBindVariables()
    {
      return m_bindVariables;
    }

/**
**
** Returns a string representation of this object.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** </PRE>
**
** @return A string representation of this object.
**
*/
  public String toString()
  {
    StringBuffer l_bufObject = new StringBuffer("[" + this.getClass().getName() + "@");

    l_bufObject.append("SQL:" + m_strSql + ":");

    if (m_bindVariables != null)
    {
      l_bufObject.append(m_bindVariables.toString());
    }
    
    l_bufObject.append("]");

    return l_bufObject.toString();
  }
}


