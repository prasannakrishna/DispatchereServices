/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.util.*;

import com.sun.nio.sctp.MessageInfo;

/**
**
** This class will unpack the messages returned from the stored procedure and
** the states that were processed. It provides methods to get the messages
** repacked into a Vector of MessageInfo Objects.
**
** Message Format:
** State1;State0:Type1;Message1;ColumnName1;arg0;arg1:Type2;Message2;ColumnName2;arg0;arg1
**
** <BR><BR>
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------
** 1.0       18/12/99 SAC DCS    WEB4402  Initial release
** dcs 740   29/08/02 JH  DCS    NEW6253  Migrating to app server
** dcs 8.4.0 21/01/04 RMD DCS    PDR9178  Add new message type parameter
** </PRE>
**
*/
public class UnpackedMessage
{
  private String m_strMessageInfo;
  private Vector m_vctStates = null;
  private Vector m_vctMessageInfo = null;

/**
**
** The constructor saves the message info string, so that the other methods
** can manipulate the message.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_strMessageInfo The message info string.
**
*/
  public UnpackedMessage(String p_strMessageInfo)
  {
    m_strMessageInfo = p_strMessageInfo;
    loadStates();
  }

/**
**
** Returns a Vector of messages for the states that this Object has, that do
** not exist in the passed vector of states.
** <BR><BR>
** Reads through the passed states. Any states that this object has, that does
** not exist in the passed states has its message info saved in  the returned
** Vector.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_vctStates The states that this object will compare with.
**
** @return A vector containing MessageInfo objects for the States that were
**         not in the states passed.
**
*/
  public Vector getUnprocessedStates(Vector p_vctStates)
  {
    Vector l_vctUnprocessedStates = new Vector(5);
    loadMessageInfo();
    int l_size = m_vctMessageInfo.size();

    for (int l_index = 0; l_index < m_vctStates.size(); l_index ++)
    {
      if (p_vctStates.contains((String)m_vctStates.elementAt(l_index)) == false)
      {
        l_vctUnprocessedStates.addElement(m_vctMessageInfo.elementAt(l_index));
      }
    }

    return l_vctUnprocessedStates;
  }

/**
**
** Returns a Vector of all the states that were present in the message.
** <BR><BR>
** Reads through the message returned from the stored procedure and determines
** the states. These states are stored in the returned Vector.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return A Vector containing all the states.
**
*/
  public Vector getStates()
  {
    return m_vctStates;
  }

/**
**
** Unwraps the message passed to the constructor of this object, and gets the
** message info from it. This information is then returned.
** <BR><BR>
** Unwraps the message passed to the constructor of this object, and gets the
** message info from it. Each message, column name that caused the messages and
** the arguments for the message are stored in a MessageInfo Object. Then the
** Message Info objects are wrapped into a Vector and returned.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return A vector containing MessageInfo objects.
**
*/
  public Vector getMessageInfo()
  {
    loadMessageInfo();
    return (Vector)m_vctMessageInfo.clone();
  }

/**
**
** Unwraps the message passed to the constructor of this object if it has not
** already been done.
** <BR><BR>
** Unwraps the message passed to the constructor of this object, and gets the
** message info from it. Each message, column name that caused the messages and
** the arguments for the message are stored in a MessageInfo Object. Then the
** Message Info objects are wrapped into a instance variable Vector.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** dcs 8.4.0 21/01/04  RMD DCS     PDR9178   Add new message type parameter
** </PRE>
**
*/
  private void loadMessageInfo()
  {
    if (m_vctMessageInfo != null)
    {
      return;
    }

    // The token seperators
    String l_strRecordToken = "\002";
    String l_strToken = ";";

    // The tokenized strings
    StringTokenizer l_strRecord = null;
    StringTokenizer l_tokenizedMessages = new StringTokenizer(m_strMessageInfo,
                                                              l_strRecordToken);

    String l_strMessageType;
    String l_strCode;
    String l_strColumnName;
    String l_strColumnValue;
    m_vctMessageInfo = new Vector(5);

    // Ignore the first token, as it contains the states
    l_tokenizedMessages.nextToken();

    // Loop through the message
    while (l_tokenizedMessages.hasMoreElements() == true)
    {
      l_strRecord = new StringTokenizer(l_tokenizedMessages.nextToken(),
                                        l_strToken);

      l_strMessageType = l_strRecord.nextToken();
      l_strCode = l_strRecord.nextToken();
      l_strColumnName = l_strRecord.nextToken();

      if (l_strColumnName.equals("-0") == true)
      {
        l_strColumnName = "";
        l_strColumnValue = "";
      }
      else
      {
        l_strColumnValue = l_strRecord.nextToken();
        if (l_strColumnValue.equals("-0") == true)
        {
          l_strColumnValue = "";
        }
      }

      // Loop through the rest of the tokens as they are the arguments
      Vector l_vctArgs = new Vector(5);
      while (l_strRecord.hasMoreTokens() == true)
      {
        l_vctArgs.addElement(l_strRecord.nextToken());
      }

      // Now add all the seperate items
      /*MessageInfo l_tmp = new MessageInfo(l_strCode,
                                          l_vctArgs,
                                          l_strColumnName,
                                          l_strColumnValue,
                                          l_strMessageType);*/

      //m_vctMessageInfo.addElement(l_tmp);
    }
  }

/**
**
** This method loads the states into m_vctStates.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
*/
  private void loadStates()
  {
    int l_index = 0;

    // If we have not already retrieved the states, do so.
    if (m_vctStates == null)
    {
      m_vctStates = new Vector(5);
      int l_endMarker = m_strMessageInfo.indexOf("\002");
      String l_states = m_strMessageInfo.substring(0,l_endMarker);
      StringTokenizer l_tknMessage = new StringTokenizer(l_states, ";");

      for(; l_tknMessage.hasMoreTokens() == true;)
      {
        m_vctStates.addElement(l_tknMessage.nextToken());
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
** 1.0       23/03/00  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return A string representation of this object.
**
*/
  public String toString()
  {
    StringBuffer l_bufObject = new StringBuffer(this.getClass().getName() + "@");

    l_bufObject.append("Size:" + m_strMessageInfo + ":");
    l_bufObject.append("CurrentSize:" + m_vctStates.toString() + ":");
    l_bufObject.append("CurrentSize:" + m_vctMessageInfo.toString() + ":");

    return l_bufObject.toString();
  }
}

