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
** This class will be used to pass bind variable data to the server ejb. It holds
** values and their types in arrays. The values and types are placed into this
** array via the supplied methods.  Note that at this time the only data types
** supported by this functionality are strings/longs/doubles.
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
*/
public class BindVariableData implements Serializable, Cloneable
{
  private ArrayList m_arrValues;
  private ArrayList m_arrTypes;

  /* Same as in BeanConstant but can't use BeanConstant server side so duplicated here */
  public static final int c_DataTypeString = 0;
  public static final int c_DataTypeLong = 1;
  public static final int c_DataTypeDouble = 2;

/**
** Creates a BindVariableData object.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
*/
  public BindVariableData()
  {
    m_arrValues = new ArrayList();    
    m_arrTypes = new ArrayList();
  }

/**
** Creates a BindVariableData object.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
** @param p_strValue The value of the bind variable.
** @param p_nType The type of the bind variable.
*/
  public BindVariableData(String p_strValue,
                          int p_nType)
  {
    this();
    put(p_strValue, p_nType);
  }

/**
** This method stores the bind variable value and type.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
** @param p_strValue The value of the bind variable.
** @param p_nType The type of the bind variable.
*/
  public void put(String p_strValue,
                  int p_nType)
  {
    String l_strValue = (p_strValue == null) ? "" : p_strValue;
    
    m_arrValues.add(l_strValue);
    
    Integer l_nType = p_nType;

    if (l_nType != c_DataTypeString
    && l_nType != c_DataTypeLong
    && l_nType != c_DataTypeDouble)
    {
      l_nType = c_DataTypeString;
    }
    
    m_arrTypes.add(Integer.valueOf(l_nType));
  }
  
/**
** This method returns the value at the passed index.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
** @param p_nIndex The index of the value to be retrieved.
** @return The value at the specified index.
** @exception java.lang.ArrayIndexOutOfBoundsException If an invalid index was given.
*/
  public String getValue(int p_nIndex)
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
** This method returns the type at the passed index.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
** @param p_nIndex The index of the type to be retrieved.
** @return The type at the specified index.
** @exception java.lang.ArrayIndexOutOfBoundsException If an invalid index was given.
*/
  public int getType(int p_nIndex)
  {
    // Check that the index is valid
    if (p_nIndex > m_arrValues.size()
    || p_nIndex < 0)
    {
      throw new ArrayIndexOutOfBoundsException("Invalid Index: " + p_nIndex);
    }

    return (Integer)m_arrTypes.get(p_nIndex);
  }

/**
** This method returns the current number of values stored in this object.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
** @return The number of values stored in this object.
*/
  public int size()
  {
    return m_arrValues.size();
  }

/**
** Returns a string representation of this object and all its data. The first
** part of the string is the objects type followed by a @ and then the data.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 2009.2-b  15/07/09 JH  dcs    DSP2683  Add bind variable support
** </PRE>
** @return String representation of object.
*/
  public String toString()
  {
    StringBuffer l_bufObject = new StringBuffer("[" + this.getClass().getName() + "@");

    l_bufObject.append("Size:" + m_arrValues.size() + ":");
    l_bufObject.append("Values:{");

    for (int i=0; i < m_arrValues.size();i ++)
    {
      l_bufObject.append((String)m_arrValues.get(i) + ":");
    }

    // Insert the end indicator
    l_bufObject.insert(l_bufObject.length() - 1, '}');
    l_bufObject.append("Types:{");

    for (int i=0; i < m_arrTypes.size(); i++)
    {
      l_bufObject.append((Integer)m_arrTypes.get(i) + ":");
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
    BindVariableData l_clone = new BindVariableData();

    l_clone.m_arrValues = (ArrayList)m_arrValues.clone();
    l_clone.m_arrTypes = (ArrayList)m_arrTypes.clone();
    
    return l_clone;
  }
}
