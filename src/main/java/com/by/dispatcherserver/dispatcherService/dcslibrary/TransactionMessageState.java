/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

/**
* This class stores the warning state when processing transaction messages.
* in displayTransactionMessages().
* <PRE>
* Release   Date     By  Proj   Ref      Description
* --------- -------- --- ------ -------- --------------------------------
* </PRE>
*/
public class TransactionMessageState
{
  private boolean m_bIgnoreWarnings = false;
  
  /**
   * Creates an instance of the class TransactionMessageState and sets the
   * default behaviour to not ignore warnings.
   */
  public TransactionMessageState()
  {
    m_bIgnoreWarnings = false;
  }

  /**
   * Enables the state so warnings are ignored.
   */
  public void enableIgnoreWarnings()
  {
    m_bIgnoreWarnings = true;
  }
  
  /**
   * Disables the state so warnings are no longer ignored.
   */
  public void disableIgnoreWarnings()
  {
    m_bIgnoreWarnings = false;
  }

  /**
   * Returns true if warnings are currently being ignored.
   * <P>
   * @return Whether warnnings are being ignored
   */
  public boolean ignoreWarningsEnabled()
  {
    return m_bIgnoreWarnings;
  }
}



