/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2017 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.util.*;
import java.io.*;

/**
**
** This class stores states for transactions of types Insert, Update and
** Delete. It will allow the Client EJB to determine what processing it
** should do for a transaction.
** <BR><BR>
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------
** 1.0       21/12/99 SAC DCS    WEB4402  Initial Release
** dcs 740   29/08/02 JH  DCS    NEW6253  Migrating to app server
** 2017.1.0  19/06/17 NS  DCS    DSP11541 SIG: MQS screens GUI validation
** </PRE>
**
*/
public class TransactionState implements Serializable
{
  private boolean m_bPreProcessed = false;
  private boolean m_bExecuteProcessed = false;
  private boolean m_bPostProcessed = false;
  private boolean m_bValProcessed = false;
  private boolean m_bDoProcessed = false;
  private Vector m_vctStates = null;

/**
**
** Creates an instance of the class TransactionState, and generates a unique
** transaction id.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       18/12/99  SAC DCS     WEB4402   Initial Release
** </PRE>
**
*/
  public TransactionState()
  {
    m_vctStates = new Vector(7);
  }

/**
**
** This method merges the passed states with the states that this object knows
** about.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_vctStates A Vector of the states to merge with this object.
**
** @return A Vector containing the merged states.
**
*/
  public Vector mergeStates(Vector p_vctStates)
  {
    for (int l_nIndex = 0; l_nIndex < p_vctStates.size(); l_nIndex ++)
    {
      m_vctStates.addElement((String)p_vctStates.elementAt(l_nIndex));
    }

    return (Vector)m_vctStates.clone();
  }

/**
**
** This method sets the known states for this object.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_vctStates The Vector of the states that this object should use.
**
** @return void.
**
*/
  public void setStates(Vector p_vctStates)
  {
    m_vctStates = (Vector)p_vctStates.clone();
  }

/**
**
** This method returns a vector of the known states. The returned vector is a
** clone, making it read only hence protecting the state information.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return A vector of the known states.
**
*/
  public Vector getStates()
  {
    return (Vector)m_vctStates.clone();
  }

/**
**
** This method returns a boolean indicating whether the execute transaction
** has been pre processed or not.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return True if execute transaction has been pre processed, or false if it has not.
**
*/
  public boolean hasBeenPreProcessed()
  {
    return m_bPreProcessed;
  }

/**
**
** This method returns a boolean indicating whether the execute transaction
** has been executed the transaction or not.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return True if the execute transaction has executed the transaction, or false if it has not.
**
*/
  public boolean hasBeenExecuted()
  {
    return m_bExecuteProcessed;
  }

/**
**
** This method returns a boolean indicating whether the execute transaction
** has been post processed or not.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @return True if the execute transaction has been post processed, or false if it has not.
**
*/
  public boolean hasBeenPostProcessed()
  {
    return m_bPostProcessed;
  }
  
  /**
  **
  ** This method returns a boolean indicating whether the execute transaction
  ** has been post processed or not.
  ** <BR><BR>
  ** <PRE>
  ** Release   Date      By  Proj    Ref       Description
  ** --------- --------  --- ------  --------  --------------------------------
  ** 2017.1.0  19/06/17  NS  DCS    DSP11541 SIG: MQS screens GUI validation
  ** </PRE>
  **
  ** @return True if the execute transaction has been post processed, or false if it has not.
  **
  */
    public boolean hasBeenValProcessed()
    {
      return m_bValProcessed;
    } 
    
    /**
     **
     ** This method returns a boolean indicating whether the execute transaction
     ** has been post processed or not.
     ** <BR><BR>
     ** <PRE>
     ** Release   Date      By  Proj    Ref       Description
     ** --------- --------  --- ------  --------  --------------------------------
     ** 2017.1.0  19/06/17  NS  DCS    DSP11541 SIG: MQS screens GUI validation
     ** </PRE>
     **
     ** @return True if the execute transaction has been post processed, or false if it has not.
     **
     */
       public boolean hasBeenDoProcessed()
       {
         return m_bDoProcessed;
       }    

/**
**
** This method sets the pre processed status for this object to the passed value.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_bStatus The status of the pre procssing for this transaction.
**
** @return void.
**
*/
  public void setPreProcessed(boolean p_bStatus)
  {
    m_bPreProcessed = p_bStatus;
  }

/**
**
** This method sets the execute transaction status for this object to the
** passed value.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_bStatus The status of the execute procssing for this transaction.
**
** @return void.
**
*/
  public void setExecuteProcessed(boolean p_bStatus)
  {
    m_bExecuteProcessed = p_bStatus;
  }

/**
**
** This method sets the post processed status for this object to the passed
** value.
** <BR><BR>
** <PRE>
** Release   Date      By  Proj    Ref       Description
** --------- --------  --- ------  --------  --------------------------------
** 1.0       16/12/99  SAC DCS     WEB4402   Initial release
** </PRE>
**
** @param p_bStatus The status of the post procssing for this transaction.
**
** @return void.
**
*/
  public void setPostProcessed(boolean p_bStatus)
  {
    m_bPostProcessed = p_bStatus;
  }
  
  /**
  **
  ** This method sets the post processed status for this object to the passed
  ** value.
  ** <BR><BR>
  ** <PRE>
  ** Release   Date      By  Proj    Ref       Description
  ** --------- --------  --- ------  --------  --------------------------------
  ** 2017.1.0  19/06/17  NS  DCS    DSP11541 SIG: MQS screens GUI validation
  ** </PRE>
  **
  ** @param p_bStatus The status of the Validation processing for this transaction.
  **
  ** @return void.
  **
  */
    public void setValProcessed(boolean p_bStatus)
    {
      m_bValProcessed = p_bStatus;
    }

    /**
     **
     ** This method sets the post processed status for this object to the passed
     ** value.
     ** <BR><BR>
     ** <PRE>
     ** Release   Date      By  Proj    Ref       Description
     ** --------- --------  --- ------  --------  --------------------------------
     ** 2017.1.0  19/06/17  NS  DCS    DSP11541 SIG: MQS screens GUI validation
     ** </PRE>
     **
     ** @param p_bStatus The status of the Validation processing for this transaction.
     **
     ** @return void.
     **
     */
       public void setDoProcessed(boolean p_bStatus)
       {
         m_bDoProcessed = p_bStatus;
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

    l_bufObject.append("PreProcessed:" + m_bPreProcessed + ":");
    l_bufObject.append("ExecuteProcessed:" + m_bExecuteProcessed + ":");
    l_bufObject.append("PostProcessed:" + m_bPostProcessed + ":");
    l_bufObject.append("StatesProcessed:" + m_vctStates.toString() + ":");

    return l_bufObject.toString();
  }
}



