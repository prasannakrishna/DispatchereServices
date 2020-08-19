/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2014 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

/**
**
** Interface defining general constants.
** <BR><BR>
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------------
** 1.0       06/11/99 AJH dcs    WEB4400  Initial version
** dcs 6.0.1 03/01/01 RMD dcs    WEB4362  Added customer to user table
** dcs 740   29/08/02 JH  DCS    NEW6253  Migrating to app server
** dcs 820   11/09/03 JH  dcs    NEW6622  WebView reporting
** 2005.1    06/04/05 JH  dlxdsp PDR09540 Web client performance issues
** 2006.1.0  05/04/06 JH  dcs    ENH1911  Web services support
** 2006.2.1  26/10/06 JH  DCS    ENH3221  Web client workstation support
** 2006.2.1  04/12/06 JH  DCS    ENH3363  Encrypt/decrypt web client user passwords
** 2007.2.0  16/10/07 JH  DCS    DSP1377  Web services method wrapper
** 2008.1-b  19/11/07 SL  DCS    DSP1433  Added Gate_In_ID for Yard
** 2008.1-b  16/01/08 SL  DCS    DSP1409  Added Gate_Out_ID for Yard
** 2010.2.0  13/08/10 JH  DCS    DSP2832  Enquirer licencing
** 2011.2-b  28/03/11 RMD dcs    DSP3858  Site Visibility Groups
** 2012.1.1  21/05/12 JH  dcs    DSP5210  Migrate mobile application into system
** </PRE>
**
*/
public interface GeneralConstant
{
  //
  // The following constant arrays of string allows the ClientEJB to read
  // User information from the Application_User table.
  //
  public static final String[] c_UserColumns  = {"AU.GROUP_ID",
                                                 "AU.OWNER_ID",
                                                 "AU.SITE_GROUP",
                                                 "AU.SHIFT",
                                                 "AU.SYSTEM_OVERVIEW",
                                                 "AU.LANGUAGE",
                                                 "AU.LOCALITY",
                                                 "AU.SUPPLIER_ID",
                                                 "AU.CUSTOMER_ID",
                                                 "NVL(AU.ALLOW_SITE_CHANGE,'N')",
                                                 "AU.CLIENT_VIS_GROUP",
                                                 "NVL(UG.ENQUIRER_USER,'N')",
						 "AU.NAME"};

  public static final String[] c_UserKeyNames = {"GROUP_ID",
                                                 "OWNER_ID",
                                                 "SITE_GROUP",
                                                 "SHIFT",
                                                 "SYSTEM_OVERVIEW",
                                                 "LANGUAGE",
                                                 "LOCALITY",
                                                 "SUPPLIER_ID",
                                                 "CUSTOMER_ID",
                                                 "ALLOW_SITE_CHANGE",
                                                 "CLIENT_VIS_GROUP",
                                                 "ENQUIRER_USER",
						 "NAME"};

  //
  // The following constant arrays of string allows the ClientEJB to read
  // Workstation information from the Workstation table.
  //
  public static final String[] c_WorkStationColumns  = {"GROUP_ID",
                                                        "SITE_ID",
                                                        "RECDOCK_ID",
                                                        "KITTING_LOC_ID",
                                                        "REPACK_LOC_ID",
                                                        "SHIPDOCK_ID",
                                                        "GATE_IN_ID",
                                                        "GATE_OUT_ID"};

  public static final String[] c_WorkStationKeyNames = {"GROUP_ID",
                                                        "SITE_ID",
                                                        "RECDOCK_ID",
                                                        "KITTING_LOC_ID",
                                                        "REPACK_LOC_ID",
                                                        "SHIPDOCK_ID",
                                                        "GATE_IN_ID",
                                                        "GATE_OUT_ID"};

  //
  // Constants for client/server logging levels
  //
  // 	Fatal		- Fatal errors
  //  Error		- Errors
  //	Warning	- Warnings (default level)
  //	Debug		- Dynamic sql statements
  //	Info		- Stack trace/timing information
  //
  public static final int c_LoggingLevelAlways = 0;
  public static final int c_LoggingLevelFatal = 1;
  public static final int c_LoggingLevelError = 2;
  public static final int c_LoggingLevelWarning = 3;
  public static final int c_LoggingLevelDebug = 4;
  public static final int c_LoggingLevelInfo = 5;

  //
  // Constants for types of sql transactions
  //
  public static final int	c_SQLTransTypeSelect = 1;
  public static final int	c_SQLTransTypeInsert = 2;
  public static final int	c_SQLTransTypeUpdate = 3;
  public static final int	c_SQLTransTypeDelete = 4;

  //
  // Constants for ejb request types
  //
  public static final int	c_EJBReqTypeConnection = 199;
  public static final int	c_EJBReqTypeOperation  = 299;
  public static final int	c_EJBReqTypeInterface  = 399;

  //
  // Constants for ejb connection actions
  //
  public static final int	c_EJBReqActConExecuteSelect = 101;
  public static final int	c_EJBReqActConUpdateApplicationSession = 102;
  public static final int	c_EJBReqActConPing = 103;
  public static final int	c_EJBReqActConGetIniSettings = 104;
  public static final int	c_EJBReqActConIsLanguageTextDownloadRequired = 105;
  public static final int	c_EJBReqActConIsTableSummaryDownloadRequired = 106;
  public static final int	c_EJBReqActConLoginUser = 107;
  public static final int	c_EJBReqActConGetLanguageText = 108;
  public static final int	c_EJBReqActConGetTableSummary = 109;
  public static final int	c_EJBReqActConDeleteApplicationSession = 110;
  public static final int	c_EJBReqActConExecuteMultipleSelects = 111;
  public static final int c_EJBReqActConGetLoginScreenProperties = 112;

  //
  // Constants for ejb operation actions
  //
  public static final int	c_EJBReqActOpsGetDateTime = 201;
  public static final int	c_EJBReqActOpsGetGlobalFunctionAccess = 202;
  public static final int	c_EJBReqActOpsGetLocalFunctionAccess = 203;
  public static final int	c_EJBReqActOpsGetSessionSetting = 204;
  public static final int	c_EJBReqActOpsExecuteStatement = 205;
  public static final int	c_EJBReqActOpsExecuteTransaction = 206;
  public static final int	c_EJBReqActOpsExecuteOperation = 207;
  public static final int	c_EJBReqActOpsGetKey = 208;
  public static final int	c_EJBReqActOpsSetSessionSetting = 209;
  public static final int	c_EJBReqActOpsRemoveSessionSettings = 210;
  public static final int	c_EJBReqActOpsChangePassword = 211;
  public static final int	c_EJBReqActOpsLogoutUser = 212;
  public static final int	c_EJBReqActOpsGetMenuGlobalAccesses = 213;
  public static final int	c_EJBReqActOpsExecuteMultipleStatements = 214;
  public static final int	c_EJBReqActOpsExecuteMultipleOperations = 215;
  public static final int	c_EJBReqActOpsGetNavigatorMenuData = 216;
  public static final int	c_EJBReqActOpsValidatePassword = 217;

  //
  // Constants for ejb interface actions
  //
  public static final int c_EJBReqActInterfaceMerge = 301;
  public static final int c_EJBReqActInterfaceExtract = 302;
  public static final int c_EJBReqActInterfaceSelect = 303;
  public static final int c_EJBReqActInterfaceConfirm = 304;
  public static final int c_EJBReqActInterfaceMethod = 305;
  
  //
  // Constants for jsp screen parameters
  //
  public static final String c_JSPParamUserID = "dcs_p1";
  public static final String c_JSPParamStationID = "dcs_p2";
  public static final String c_JSPParamSessionID = "dcs_p3";
  public static final String c_JSPParamLanguage = "dcs_p4";
  public static final String c_JSPParamLocality = "dcs_p5";

  //
  // Constants for android parameters
  //
  public static final String c_DefaultFileExtension = ".ser";
  public static final String c_DefaultCameraSaveFileName = "DispatcherCameraPicture";
  public static final String c_DefaultMediaID = "Mobile Device Camera - ";
  public static final String c_DefaultCameraSaveFileExtension = "jpg";
  public static final String c_DefailtCameraUploadDescription = "Photo taken on Android Device";
  public static final int c_MessageTypeSuccess = 0;
  public static final int c_MessageTypeInfo = 1;
  public static final int c_MessageTypeWarning = 2;
  public static final int c_MessageTypeError = 3;
  public static final int c_ConMaxConAttempts = 3;
  public static final int c_ConTimeoutMilli = 10000;
  public static final boolean c_SupressLanguageWarnings = false;
  public static final int c_TargetPictureWidth = 800;
}

