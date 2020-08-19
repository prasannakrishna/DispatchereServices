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
** Structure for servlet responses.
** <BR><BR>
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------------
** dcs 740   27/09/02 JH  DCS    NEW6253  Migrating to app server
** 2006.1.2  18/05/06 JH  DCS    ENH2758  Web service support (phase 3)
** 2008.2.1  09/12/08 JH  dcs    DSP2181  Web logic transaction issue
** </PRE>
**
*/
public class DCSResponse implements Serializable
{
  public boolean m_bSuccess = false;
  public String m_strErrorCode = null;
  public String m_strErrorDescription = null;
  public Object m_object = null;
  public boolean m_bInterfaceRollback = false;
}
