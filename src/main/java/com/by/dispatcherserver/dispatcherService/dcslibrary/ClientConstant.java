/******************************************************************************/
/*                                                                            */
/*  Copyright (c) 2015 JDA Software Group, Inc.                               */
/*  All rights reserved - Company Confidential                                */
/*                                                                            */
/******************************************************************************/

package com.by.dispatcherserver.dispatcherService.dcslibrary;

import java.awt.event.*;

/**
**
** Interface defining client screen constants.
** <BR><BR>
** <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------------
** 1.0       06/11/99 AJH dcs    WEB4301  Initial version
** 1.0       06/11/99 AJH dcs    WEB4305  Initial version
** 1.0       16/08/00 AJH dcs    WEB4308  User colour settings
** 6.1.1     08/03/01 CJD dcs    WEB4310  Pack images in JAR file
** dcs 740   27/09/02 JH  DCS    NEW6253  Migrating to app server
** dcs 7.4.0 28/10/02 CJD DCS    NEW6008  Add default ship and receive dock
** dcs 8.1.0 17/04/03 RMD dcs    NEW6617  Moved to dcslibrary
** vvd 2.5.1 12/03/04 SNP vvd    NEW6918  RedPrairie Changes
** dcs 8.4.4 17/09/04 EW  ab     NEW7644  Activity Billing Screens Added
** 2005.2.1  10/10/05 RMD dcs    NEW7454  Add open file/url session settings
** 2006.1-b  10/11/05 SL  dcs    NEW7927  Add Default Repack Loc ID
** 2006.2.0  06/04/06 RMD dcs    ENH2482  Add new progress bar constants
** 2006.2-b  05/07/06 CD  dcs    BUG2800  PDF printing does not support unicode fonts
** 2006.2.0  05/09/06 JH  dcs    ENH3005  Increase record set size/auto table mode/use rownum
** 2006.2.1  03/11/06 DGP DCS    BUG3262  Add Default Kitting Loc ID
** 2007.1.0  06/03/06 RMD dcs    ENH3545  Add F12 shortcut to save buttons
** 2007.1.0  26/03/07 JH  dcs    ENH3552  Add icons into web client menu
** 2007.1.1  01/05/07 JH  DCS    ENH3658  Allow label alignment to be specified
** 2007.1.2  12/07/07 JH  DCS    DSP1250  Allow setting of main menu colour
** 2007.1.2  21/07/07 JH  DCS    DSP1250  Add themes to the web client
** 2008.1-b  19/11/07 SL  DCS    DSP1433  Add default Yard Gate In
** 2008.1-b  16/01/08 SL  DCS    DSP1409  Add default Yard Gate Out
** 2009.2-b  02/04/09 SNP DCS    DISP2403 SCC - Client Library Java
** 2009.2.0  27/08/09 JH  DCS    DSP2719  Web client messaging
** 2010.2-b  24/02/10 DL  DCS    DSP2314  Single sign on functionality
** 2012.2.0  18/09/12 JH  DCS    DSP5595  Work out whether any media data
** 2013.1.0  16/02/13 JH  DCS    DSP6023  Change web client on-line to use the user assistance portal
** 2013.1.2  09/07/13 RMD DCS    DSP6342  Add on-line help authentication
** 2013.2.0  07/12/13 JH  DCS    DSP6141  In-store picking
** </PRE>
**
*/
public interface ClientConstant
{
  //
  // Version constant (should match contents of version.web_version)
  //
  public final static String c_WebVersion = " 2019.1.0.1";
  
  //
  // Constants for supporting new OnLine Expert on-line help
  //
  public final static boolean c_HelpTopicOLE = true;
  public final static String c_HelpTopicOLEIndex = "index.htm";
  public final static String c_HelpOLESubDirectoryISP = "ISP/";
  public final static String c_HelpOLESubDirectoryWMS = "WMS/";
  public final static String c_HelpOLESIndexReference = "index.htm#";
  public final static String c_HelpfilesOLE = "HelpfilesOLE/";

  //
  // Constants for support new user assistance portal on-line help
  //
  public final static boolean c_HelpTopicPortal = true; /* If you change this you also need to tweak classes/Templates/dcsclient.Navigator.html */
  public final static String c_HelpTopicUrl = "https://wiki.redprairie.com/auth/auth.php";
  public final static String c_HelpTopicVersionWMS = "/display/WMR132/";
  public final static String c_HelpTopicVersionISP = "/display/ISP132/";
  public final static String c_HelpTopicWelcomeWMS = "Dispatcher+GUI+Screens";
  public final static String c_HelpTopicWelcomeISP = "In-Store+Picking+GUI+Screens";
  public final static String c_InStorePickingSystemType = "8";
  
  //
  // Application name constants (used for differing between wms & vv)
  //
  public final static String c_ApplicationNameWMS = "WV";
  public final static String c_ApplicationNameVV = "VV";
  public final static String c_ApplicationNameAB = "AB";
  public final static String c_ApplicationNameIF = "IF";
  public final static String c_ApplicationName = c_ApplicationNameWMS;
  public final static String c_JnlpApplicationName = "Dispatcher WMS";

  //
  // General screen constants
  //
  public final static int c_Undefined = -1;
  public final static String c_DefaultLanguage = "EN_GB";
  public final static String c_LabelPrefixLookup = "WLK";
  public final static String c_LabelPrefixToolTipText = "WTT";
  public final static String c_LabelPrefixButton = "WBT";
  public final static String c_ApplicationSessionBlank = "blank_screen";
  public final static String c_LoginPageParameter = "NAME";
  public final static String c_TabPlacementBottom = "B";

  //
  // File name component constants
  //
  public final static String c_FileBaseDirectory = "dcsi";
  public final static String c_FileDcsClient = "dcsclient.";
  public final static String c_FileUserLogin = "UserLogin";
  public final static String c_FileUserLoginSSO = "UserLoginSSO";
  public final static String c_FileUserLoginTest = "UserLoginTest";
  public final static String c_FilePasswordChange = "PasswordChange";
  public final static String c_FileMainScreen = "MainScreen";
  public final static String c_FileExtnHtm = ".htm";
  public final static String c_FileExtnHtml = ".html";
  public final static String c_FileExtnLight = ".light";
  public final static String c_FileExtnPhp = ".php";
  public final static String c_FileExtnTxt = ".txt";
  public final static String c_FileExtnSer = ".ser";
  public final static String c_FileExtnGif = ".gif";
  public final static String c_FileExtnPng = ".png";
  public final static String c_FileExtnPdf = ".pdf";
  public final static String c_FileExtnTtf = ".ttf";
  public final static String c_FileTableSummary = "table_summary";
  public final static String c_FileTraceFile = "dcsclient.trc";
  public final static String c_FileTraceFileOld = "dcsclientold.trc";
  public final static String c_FileOverride = "override";
  public final static String c_FileIndexHtml = "index.html";
  public final static String c_FontRPArial = "RPArial";

  //
  // Image file name constants
  //
  public final static String c_Images = "Images/";
  public final static String c_ImagesSku = c_Images + "Sku/";
  public final static String c_ImagesLogo = c_Images + "Logo/";
  public final static String c_ImagesGeneral = c_Images + "General/";
  public final static String c_ImagesIcons = c_Images + "Icons/";
  public final static String c_ImagesProductInformationMissing = "ProductInformationMissing";
  public final static String c_ImagesProductInformationIndex = "ProductInformationIndex";

  //
  // Image message box icon constants
  //
  public final static String c_ImagesCorrect = c_ImagesGeneral + "Correct.png";
  public final static String c_ImagesError = c_ImagesGeneral + "Error.png";
  public final static String c_ImagesWarning = c_ImagesGeneral + "Warning.png";
  public final static String c_ImagesLock = c_ImagesGeneral + "Lock.png";
  public final static String c_ImagesUnlock = c_ImagesGeneral + "Unlock.png";
  public final static String c_ImageFavicon = c_ImagesLogo + "blueyonder_Blue.png";
  public final static String c_ImageLoginLoding = c_ImagesGeneral + "UserLoginLoading.gif";

  //
  // Image MainMenu icon constants
  //
  public final static String c_ImagesExport = "Export.png";
  public final static String c_ImagesExportDisabled = "ExportDisabled.png";
  public final static String c_ImagesExportPressed = "ExportPressed.png";
  public final static String c_ImagesExportRollover = "ExportRollover.png";
  public final static String c_ImagesHelp = "Help.png";
  public final static String c_ImagesHelpPressed = "HelpPressed.png";
  public final static String c_ImagesHelpRollover = "HelpRollover.png";
  public final static String c_ImagesLogout = "Logout.png";
  public final static String c_ImagesLogoutPressed = "LogoutPressed.png";
  public final static String c_ImagesLogoutRollover = "LogoutRollover.png";
  public final static String c_ImagesMessage = "Message.png";
  public final static String c_ImagesMessageDisabled = "MessageDisabled.png";
  public final static String c_ImagesMessageRollover = "MessageRollover.png";
  public final static String c_ImagesMessagePressed = "MessagePressed.png";
  public final static String c_ImagesPrint = "Print.png";
  public final static String c_ImagesPrintDisabled = "PrintDisabled.png";
  public final static String c_ImagesPrintRollover = "PrintRollover.png";
  public final static String c_ImagesPrintPressed = "PrintPressed.png";
  public final static String c_ImagesProgress = "LogoutTimer";
  public final static String c_ImagesProgressDisabled = "LogoutTimerDisabled";
  public final static String c_ImagesFindScreen = "FindScreen.png";
  public final static String c_ImagesFindScreenDisabled = "FindScreenDisabled.png";
  public final static String c_ImagesFindScreenRollover = "FindScreenRollover.png";
  public final static String c_ImagesFindScreenPressed = "FindScreenPressed.png";
  public final static String c_ImagesUserMessage = "NewMessage.png";
  public final static String c_ImagesUserMessageDisabled = "MessageDisabled.png";
  public final static String c_ImagesUserMessageRollover = "NewMessageRollover.png";
  public final static String c_ImagesUserMessagePressed = "NewMessagePressed.png";
  public final static String c_ImagesMediaExists = "MediaExists.png";

  public final static String c_ImageSystemUnavailble ="Images/General/SystemUnavailable.jpg";
  //
  // Window names for new browser windows constants
  //
  public final static String c_WindowParent = "_parent";
  public final static String c_WindowRightFrame = "RightFrame";
  public final static String c_WindowLIS = "DCSWindowLIS";
  public final static String c_WindowCustomer = "DCSWindowCustomer";
  public final static String c_WindowHelp = "DCSWindowHelp";
  public final static String c_WindowProductInformation = "DCSWindowProductInformation";
  public final static String c_WindowWelcome = "DCSWindowWelcome";

  //
  // Help file name component constants
  //
  public final static String c_Helpfiles = "HelpfilesOLE/";
  public final static String c_HelpSubDirectory = "WindowsGeneral/";
  public final static String c_HelpNotAvailable = "HelpNotAvailable.htm";
  public final static String c_HelpWelcome = "HelpWelcome.htm";
  public final static String c_HelpMultipleScreenRunner = "MultipleScreenRunner";
  public final static String c_HelpPrefix = "Help";
  public final static String c_HelpSystemUnavailable = "InfoSystemUnavailable.htm";
  public final static String c_HelpSecuritySettingsInvalid = "InfoSecuritySettingsInvalid.htm";
  public final static String c_HelpScreenStartupProblem = "InfoScreenStartupProblem.htm";
  public final static String c_HelpUserAlreadyLoggedIn = "InfoUserAlreadyLoggedIn.htm";

  //
  // Session settings constants
  //
  public final static String c_SessionSettingsTypeGeneral = "GENERAL";
  public final static String c_SessionSettingsTypeColours = "COLOURS";
  public final static String c_SessionSettingsTypeColumns = "COLUMNS";
  public final static String c_SessionSettingsRecordSetSize = "settings_record_set_size";
  public final static String c_SessionSettingsClientTraceLevel = "settings_client_trace_level";
  public final static String c_SessionSettingsClientTraceDialogue = "settings_client_trace_dialogue";
  public final static String c_SessionSettingsSessionLockTime = "settings_session_lock_time";
  public final static String c_SessionSettingsScreenColours = "settings_screen_colours";
  public final static String c_SessionSettingsStatusColours = "settings_status_colours";
  public final static String c_SessionSettingsDefaultShipDock = "settings_default_ship_dock";
  public final static String c_SessionSettingsDefaultRepackLocID = "settings_default_repack_loc_id";
  public final static String c_SessionSettingsDefaultReceiveDock = "settings_default_receive_dock";
  public final static String c_SessionSettingsDefaultKittingLocID = "settings_default_kitting_loc_id";
  public final static String c_SessionSettingsMSRTabPosition = "settings_msr_tab_position";
  public final static String c_SessionSettingsOpenFileCmd = "settings_open_file_cmd";
  public final static String c_SessionSettingsOpenURLCmd = "settings_open_url_cmd";
  public final static String c_SessionSettingsMenuIconsVisible = "settings_menu_icons_visible";
  public final static String c_SessionSettingsLabelFieldSeparate = "settings_label_field_separate";
  public final static String c_SessionSettingsDefaultMaintenance = "settings_default_maintenance";
  public final static String c_SessionSettingsDefaultReverseQuery = "settings_default_reverse_query";
  public final static String c_SessionSettingsDefaultStartQuery = "settings_default_start_query";
  public final static String c_SessionSettingsDisplayQueryWarning = "settings_display_query_warning";
  public final static String c_SessionSettingsToggleTableResults = "settings_toggle_table_results";
  public final static String c_SessionSettingsAutoSaveFavourites = "settings_auto_save_favourites";
  public final static String c_SessionSettingsThemeName = "settings_theme_name";
  public final static String c_SessionSettingsDefaultYardGateIn = "settings_default_yard_gate_in";
  public final static String c_SessionSettingsDefaultYardGateOut = "settings_default_yard_gate_out";
  
  //
  // Standard shortcut key constants
  //
  public final static int c_KeyShortcutQuery = KeyEvent.VK_F2;
  public final static int c_KeyShortcutAdd = KeyEvent.VK_F3;
  public final static int c_KeyShortcutUpdate = KeyEvent.VK_F4;
  public final static int c_KeyShortcutDelete = KeyEvent.VK_F6;
  public final static int c_KeyShortcutExecute = KeyEvent.VK_F7;
  public final static int c_KeyShortcutCancel = KeyEvent.VK_F8;
  public final static int c_KeyShortcutRefresh = KeyEvent.VK_F9;
  public final static int c_KeyShortcutLess = KeyEvent.VK_F9;
  public final static int c_KeyShortcutMore = KeyEvent.VK_F10;
  public final static int c_KeyShortcutLines = KeyEvent.VK_F11;
  public final static int c_KeyShortcutDone = KeyEvent.VK_F12;
  public final static int c_KeyShortcutClose = KeyEvent.VK_ESCAPE;
  public final static int c_KeyShortcutEnter = KeyEvent.VK_ENTER;
  public final static int c_KeyShortcutSpace = KeyEvent.VK_SPACE;
  public final static int c_KeyShortcutEquals = KeyEvent.VK_EQUALS;
  public final static int c_KeyShortcutTab = KeyEvent.VK_TAB;
  public final static int c_KeyShortcutAsterisk = KeyEvent.VK_ASTERISK;
  public final static int c_KeyShortcutMinus = KeyEvent.VK_MINUS;
  public final static int c_KeyShortcutPlus = KeyEvent.VK_PLUS;
  public final static int c_KeyShortcutSlash = KeyEvent.VK_SLASH;

  //
  // Auto logout and history constants
  //
  public final static int c_CountDownTime = 5;              // This is minutes
  public final static int c_CountDownGranularity = 1;       // This is minutes
  public final static int c_HistoryFavouritesDefault = 10;  // This is a count
  public final static int c_HistoryDaysDefault = 7;         // This is days

  //
  // User session colour constants
  //
  public final static int c_ScreenFontSizeLength = 2;
  public final static int c_ScreenFontSizeMaximum = 30;
  public final static int c_ScreenFontSizeMinimum = 10;

  public final static int c_ScreenRegionTitle = 0;
  public final static int c_ScreenRegionCentre = 1;
  public final static int c_ScreenRegionStatus = 2;
  public final static int c_ScreenRegionButton = 3;
  public final static int c_ScreenRegionLookup = 4;
  public final static int c_ScreenRegionMessage = 5;
  public final static int c_ScreenRegionMenu = 6;
  public final static int c_ScreenRegionTableHeader = 7;
  public final static int c_ScreenRegionScreenRunner = 8;
  public final static int c_ScreenRegionMainMenu = 9;
  public final static int c_ScreenRegionLast = 9; // Used to size array so make sure set to highest

  public final static int c_ScreenRedPrairieRed = 204;
  public final static int c_ScreenLabelBorderSize = 4;

  //
  // Maintenance/query screen constants
  //
  public final static String c_MQModeQuery = "Q";
  public final static String c_MQModeMaint = "M";
  public final static String c_MQModeArchive = "A";
  public final static String c_MQModeOther = "O";
  public final static String c_MQModeIndexHtml = "I";
  public final static String c_MQModeWebSite = "W";
  public final static int c_RecordMinimumNumber = 100;
  public final static int c_RecordDefaultNumber = 500;
  public final static int c_RecordMaximumNumber = 1000;
  public final static int c_RecordNormalIncrement = 1;
  public final static int c_RecordShiftIncrement = 10;
  public final static int c_RecordControlIncrement = 100;

  //
  // States for executeQuery
  //
  public final static byte c_SUCCESS = 0;
  public final static byte c_FAILURE = 1;
  public final static byte c_CANCELLED = 2;

  //
  // Sql statement text constants
  //
  public final static String c_SQLStmtOrderByDflt = "1 asc";
  public final static String c_SQLStmtReverseOrderByDflt = "1 desc";
  public final static String c_SQLStmtTransPrefix = "liblanguage.gettranslation";
  public final static String c_SQLStmtWhereNoRows = "rownum = 0";
  public final static String c_SQLStmtWhereNoRowsKey = "";
  public final static String c_SQLStmtSplitLowestTable = "sku";
  public final static String c_SQLStmtSplitLowestColumn = "sku_id";
  public final static String c_SQLStmtSplitLowestValue = "split_lowest";

  //
  // XML print directory/filenames
  //
  public final static String c_PrintTemplatePath = "Printing/";

  //
  // Constants for Wizard Screen Modes
  //
  final static int c_ModeWizardNAHeader = 0; // NA referring to Not Applicable
  final static int c_ModeWizardSelectHeader = 1;
  final static int c_ModeWizardAddHeader = 2;
  final static int c_ModeWizardEditHeader = 3;
  final static int c_ModeWizardFinishHeader = 4;
  final static int c_ModeWizardNALine = 5; // NA referring to Not Applicable
  final static int c_ModeWizardSelectLine = 6;
  final static int c_ModeWizardAddLine = 7;
  final static int c_ModeWizardEditLine = 8;
  
  //
  // Constants for progress bar
  //
  public final static int c_ProgressBarSize = 6; // Number of bars in indicator
  public final static int c_ProgressBarSleep = 125; // Milliseconds
  
  //
  // Billing Navigator Constants
  //
  public final static int c_BillingNavigatorRowHeight = 18;
  public final static int c_BillingNavigatorDividerSize = 12;
  public final static int c_BillingNavigatorDividerLocation = 300;
}

