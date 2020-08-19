/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.io.*;
import java.util.*;

/**
** This class will be used to pass column data to the server ejb. It  holds
** column names and their values in arrays. The values are placed into this
** array via the supplied methods.
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------
** 1.0       01/12/99 SAC DCS    WEB4402  Initial Release
** dcs 740   29/08/02 JH  DCS    NEW6253  Migrating to app server
** dcs 820   29/10/03 RMD DCS    NEW6846  Set default values
** dcs 830   25/11/03 BA  DCS    NEW6857  Pass null for column values get converted to ""
** dcs 840   04/02/04 RMD DCS    NEW6955  Change arrays to array list
** 2006.2.0  28/07/06 RMD DCS    ENH1905  Add new methods
** 2008.1.0  01/04/08 EW  DCS    DSP1434  Detaching and Attaching Transport Units
** </PRE>
*/
public class ColumnData implements Serializable, Cloneable
{
  private ArrayList m_arrNames;
  private ArrayList m_arrValues;

/**
**
** Creates a ColumnData object with an initial size. This size is only used to
** set the initial size of the array, the number of columns that can be added
** is not restricted to the valuse passed here
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       01/12/99  SAC DCS     WEB4402   Initial Release
** </PRE>
**
** @param p_nSize The number of columns that this object will store.
**
*/
  public ColumnData(int p_nSize)
  {
    m_arrNames = new ArrayList(p_nSize);
    m_arrValues = new ArrayList(p_nSize);    
  }

/**
**
** Creates a ColumnData object with an initial size of 2. This size is only
** used to set the initial size of the array, the number of columns that can
** be added is not restricted to the valuse passed here
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       01/12/99  SAC DCS     WEB4402   Initial Release
** dcs 840   04/02/04 RMD DCS    NEW6955  Change arrays to array list
** </PRE>
**
**
*/
  public ColumnData()
  {
    this(2);
  }

/**
** This method stores the column name and its value.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       13/10/99  SAC DCS     WEB4402   Initial release
** </PRE>
** @param p_strColumnName The name of the column.
** @param p_strColumnValue The value of the column.
*/
  public void put(String p_strColumnName,
      String p_strColumnValue)
  {
    String l_strValue = (p_strColumnValue == null) ? "" : p_strColumnValue;
    m_arrValues.add(l_strValue);

    m_arrNames.add(p_strColumnName);
  }
  
/**
** Stores an input value in the column data.
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** </PRE>
** @param p_inputValue The input value to store in the ColumnData
*/
  /*public void put(InputValue p_inputValue)
  {
    put(p_inputValue.getColumnName(), "'" + p_inputValue.getValue() + "'");
  }*/

/**
** Store the values from the supplied ColumnData in this ColumnData.
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** </PRE>
** @param p_columnData ColumnData to add to current values
*/
  public void put(ColumnData p_columnData)
  {
    m_arrValues.addAll(p_columnData.m_arrValues);
    m_arrNames.addAll(p_columnData.m_arrNames);
  }
    
  /**
   * Store a boolean as a String "Y" or "N"
   * <BR><BR>
   * <PRE>
   * Release   Date     By  Proj    Ref      Description
   * --------- -------- --- ------  -------- --------------------------------------
   * 2008.1.0  15/02/08 EW  DCS     DSP1434  Detaching and Attaching Transport Units
   * </PRE>
   * @param p_strColumnName
   * @param p_bColumnValue
   */
  public void put(String p_strColumnName,
      boolean p_bColumnValue)
  {
    String l_strValue;
    if(p_bColumnValue == true)
    {
      l_strValue = "Y";
    }
    else
    {
      l_strValue = "N";
    }
    put(p_strColumnName, "'" + l_strValue + "'");
  }
  
/**
**
** This method returns the value of the column name at the passed index.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       13/10/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_nIndex The index of the column name to be retrieved.
**
** @return The column name at the specified index.
**
** @exception java.lang.ArrayIndexOutOfBoundsException If an invalid index was given.
**
*/
  public String getColumnName(int p_nIndex)
  {
    // Check that the index is valid
    if (p_nIndex > m_arrNames.size()
    || p_nIndex < 0)
    {
      throw new ArrayIndexOutOfBoundsException("Invalid Index: " + p_nIndex);
    }

    return (String)m_arrNames.get(p_nIndex);
  }

/**
**
** This method returns the value of the column at the passed index.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       13/10/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_nIndex The index of the column name to be retrieved.
**
** @return The Column value at the specified index.
**
** @exception java.lang.ArrayIndexOutOfBoundsException If an invalid index was given.
**
*/
  public String getColumnValue(int p_nIndex)
  {
    // Check that the index is valid
    if (p_nIndex > m_arrValues.size()
    || p_nIndex < 0)
    {
      throw new ArrayIndexOutOfBoundsException("Invalid Index: " + p_nIndex);
    }

    return (String)m_arrValues.get(p_nIndex);
  }

/**
**
** This method will set the default values from the MessageInfo array
** into the relevant column data fields.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   29/10/03 RMD DCS    NEW6846  Set default values
** </PRE>
**
** @param p_arrMessageInfo Array of message info objects containing values
**
**
*/
  /*public void setDefaultValues(MessageInfo[] p_arrMessageInfo)
  {
    for (int i=0; i < p_arrMessageInfo.length; i++)
    {
     // MessageInfo l_info = p_arrMessageInfo[i];
      //String l_strColName = l_info.getColumnName().toLowerCase();
      //String l_strColValue = l_info.getColumnValue();

      if (l_strColName.equals("") == false
      && l_strColValue.equals("") == false)
      {
        setColumnValue(l_strColName, l_strColValue);
      }
    }
  }*/

/**
** Sets the column value for the specified column name. If a value for the 
** column name doesnt exist a new entry will be made.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** dcs 820   29/10/03 RMD DCS    NEW6846  Set default values
** </PRE>
**
** @param p_strColumnName Name of column to set
** @param p_strColumnValue Value to set for the column
**
*/
  public void setColumnValue(String p_strColumnName,
      String p_strColumnValue)
  {
    int l_index = m_arrNames.indexOf(p_strColumnName);
    if (l_index > -1)
    {
      // Found the column name so set the value
      m_arrValues.set(l_index, p_strColumnValue);
    }
    else
    {
      // Not found the value so add a new one
      put(p_strColumnName, p_strColumnValue);
    }
  }

/**
** This method returns the current number of columns stored in this object.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       13/10/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return The current number of columns stored in this object.
**
*/
  public int size()
  {
    return m_arrNames.size();
  }

/**
** Returns a string representation of this object and all its data. The first
** part of the string is the objects type followed by a @ and then the data.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       23/03/00  SAC DCS     WEB4402   Initial release
** </PRE>
** @return String representation of this object.
*/
  public String toString()
  {
    StringBuffer l_bufObject = new StringBuffer("[" + this.getClass().getName() + "@");

    l_bufObject.append("Size:" + m_arrNames.size() + ":");
    l_bufObject.append("Names:{");

    for (int i=0; i < m_arrNames.size();i ++)
    {
      l_bufObject.append((String)m_arrNames.get(i) + ":");
    }

    // Insert the end indicator
    l_bufObject.insert(l_bufObject.length() - 1, '}');
    l_bufObject.append("Values:{");

    for (int i=0; i < m_arrValues.size(); i++)
    {
      l_bufObject.append((String)m_arrValues.get(i) + ":");
    }

    // Insert the end indicator
    l_bufObject.insert(l_bufObject.length() - 1, '}');
    l_bufObject.append("]");

    return l_bufObject.toString();
  }
  
  /*
   *  (non-Javadoc)
   * @see java.lang.Object#clone()
   */
  public Object clone()
  {
    ColumnData clone = new ColumnData();

    clone.m_arrNames = (ArrayList)m_arrNames.clone();
    clone.m_arrValues = (ArrayList)m_arrValues.clone();
    
    return clone;
  }
  
  /**
   * Get the value associated with the given column name 
   * <BR><BR>
   * <PRE>
   * Release   Date     By  Proj    Ref      Description
   * --------- -------- --- ------  -------- --------------------------------------
   * 2008.1.0  01/04/08 EW  DCS     DSP1434  Detaching and Attaching Transport Units
   * </PRE>
   * @param p_strColumnName the name of the column to get
   * @return the value in the column
   */
  public String get(String p_strColumnName)
  {
    int l_nIndex = -1;
    for(int i = 0; i < m_arrNames.size(); i++)
    {
      String l_strColumnName = (String)m_arrNames.get(i);
      if(l_strColumnName != null && l_strColumnName.equals(p_strColumnName))
      {
        // Found the correct index so break out of loop
        l_nIndex = i;
        break;
      }
    }
    
    if(l_nIndex == -1)
    {
      throw new NoSuchElementException("Invalid column name " + p_strColumnName);
    }
    
    return getColumnValue(l_nIndex);
  }
}
