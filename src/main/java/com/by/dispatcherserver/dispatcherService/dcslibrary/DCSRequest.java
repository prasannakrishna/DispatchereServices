
package com.by.dispatcherserver.dispatcherService.dcslibrary;
import java.io.*;

/**
 **
 ** Structure for servlet requests. <BR>
 * <BR>
 ** 
 * <PRE>
** Release   Date     By  Proj   Ref      Description
** --------- -------- --- ------ -------- --------------------------------------
** dcs 740   27/09/02 JH  DCS    NEW6253  Migrating to app server
** dcs 800   10/02/03 JH  DCS    NEW6474  Time zone support
** dcs 840   10/02/03 JH  DCS    PDR8932  Time zone problems
** 2006.1.0  09/04/06 JH  DCS    ENH1911  Web services support
** 2006.1.1  12/05/06 JH  DCS    ENH2647  Add session instrumentation
** 2006.1.2  18/05/06 JH  DCS    ENH2758  Web service support (phase 3)
** 2006.2.0  25/08/06 JH  DCS    ENH2921  Web service support (phase 4)
** 2006.2.1  26/10/06 JH  DCS    ENH3221  Web client workstation support
** 2007.2.0  10/09/07 JH  DCS    DSP1342  Benchmarking changes
** 2007.2.0  21/09/07 JH  DCS    DSP1355  Web services reference id
** 2010.1-b  16/11/09 JH  DCS    DSP2959  Serialise merge access
** 2010.1.0  18/02/10 JH  DCS    DSP3083  Add support for islamic dates using nls_calendar
** 2010.2-b  23/02/10 DL  DCS    DSP2314  Single sign on functionality
** 2011.1.2  08/06/11 JH  DCS    DSP3989  Web services improvements
 ** </PRE>
 **
 */
public class DCSRequest implements Serializable {
	public String m_strSessionId = null;
	public int m_nCheckSum = 0;
	public int m_nTraceLevel = 5;
	public String m_strSessionType = null;
	public String m_strUserId = null;
	public String m_strUserGroup = null;
	public boolean m_bUsingHostName = false;
	public String m_strStationId = null;
	public String m_strIPAddress = null;
	public String m_strStationGroup = "";
	public String m_strLanguage = "EN_GB";
	public String m_strFunctionId = null;
	public String m_strTimeZoneName = null;
	public String m_strNlsCalendar = null;
	public String m_strLocality = null;
	public boolean m_bSqlTracing = false;
	public int m_nRequestAction = 0;
	public Object m_object = null;
	public boolean m_bInterfaceTestMode = false;
	public String m_strInterfaceOracleDateFormat = "";
	public String m_strInterfaceJavaDateFormat = "";
	public String m_strInterfaceAuthenticationKey = "";
	public String m_strInterfaceType = "";
	public String m_strInterfaceIdentifier = "";
	public String m_strInterfacePassword = "";
	public String m_strInterfaceReferenceId = "";
	public String m_strInterfaceSiteId = "";
	public String m_strInterfaceClientId = "";
	public int m_nInterfaceExpirationSecs = 0;
	public int m_nInterfaceTimeOutSecs = 0;
	public boolean m_bBenchmarkMode = false;
	public boolean m_bSSOMode = false;
	/**
	 * @param m_strSessionId
	 * @param m_nCheckSum
	 * @param m_nTraceLevel
	 * @param m_strSessionType
	 * @param m_strUserId
	 * @param m_strUserGroup
	 * @param m_bUsingHostName
	 * @param m_strStationId
	 * @param m_strIPAddress
	 * @param m_strStationGroup
	 * @param m_strLanguage
	 * @param m_strFunctionId
	 * @param m_strTimeZoneName
	 * @param m_strNlsCalendar
	 * @param m_strLocality
	 * @param m_bSqlTracing
	 * @param m_nRequestAction
	 * @param m_object
	 * @param m_bInterfaceTestMode
	 * @param m_strInterfaceOracleDateFormat
	 * @param m_strInterfaceJavaDateFormat
	 * @param m_strInterfaceAuthenticationKey
	 * @param m_strInterfaceType
	 * @param m_strInterfaceIdentifier
	 * @param m_strInterfacePassword
	 * @param m_strInterfaceReferenceId
	 * @param m_strInterfaceSiteId
	 * @param m_strInterfaceClientId
	 * @param m_nInterfaceExpirationSecs
	 * @param m_nInterfaceTimeOutSecs
	 * @param m_bBenchmarkMode
	 * @param m_bSSOMode
	 */
	public DCSRequest(String m_strSessionId, int m_nCheckSum, int m_nTraceLevel, String m_strSessionType,
			String m_strUserId, String m_strUserGroup, boolean m_bUsingHostName, String m_strStationId,
			String m_strIPAddress, String m_strStationGroup, String m_strLanguage, String m_strFunctionId,
			String m_strTimeZoneName, String m_strNlsCalendar, String m_strLocality, boolean m_bSqlTracing,
			int m_nRequestAction, Object m_object, boolean m_bInterfaceTestMode, String m_strInterfaceOracleDateFormat,
			String m_strInterfaceJavaDateFormat, String m_strInterfaceAuthenticationKey, String m_strInterfaceType,
			String m_strInterfaceIdentifier, String m_strInterfacePassword, String m_strInterfaceReferenceId,
			String m_strInterfaceSiteId, String m_strInterfaceClientId, int m_nInterfaceExpirationSecs,
			int m_nInterfaceTimeOutSecs, boolean m_bBenchmarkMode, boolean m_bSSOMode) {
		this.m_strSessionId = m_strSessionId;
		this.m_nCheckSum = m_nCheckSum;
		this.m_nTraceLevel = m_nTraceLevel;
		this.m_strSessionType = m_strSessionType;
		this.m_strUserId = m_strUserId;
		this.m_strUserGroup = m_strUserGroup;
		this.m_bUsingHostName = m_bUsingHostName;
		this.m_strStationId = m_strStationId;
		this.m_strIPAddress = m_strIPAddress;
		this.m_strStationGroup = m_strStationGroup;
		this.m_strLanguage = m_strLanguage;
		this.m_strFunctionId = m_strFunctionId;
		this.m_strTimeZoneName = m_strTimeZoneName;
		this.m_strNlsCalendar = m_strNlsCalendar;
		this.m_strLocality = m_strLocality;
		this.m_bSqlTracing = m_bSqlTracing;
		this.m_nRequestAction = m_nRequestAction;
		this.m_object = m_object;
		this.m_bInterfaceTestMode = m_bInterfaceTestMode;
		this.m_strInterfaceOracleDateFormat = m_strInterfaceOracleDateFormat;
		this.m_strInterfaceJavaDateFormat = m_strInterfaceJavaDateFormat;
		this.m_strInterfaceAuthenticationKey = m_strInterfaceAuthenticationKey;
		this.m_strInterfaceType = m_strInterfaceType;
		this.m_strInterfaceIdentifier = m_strInterfaceIdentifier;
		this.m_strInterfacePassword = m_strInterfacePassword;
		this.m_strInterfaceReferenceId = m_strInterfaceReferenceId;
		this.m_strInterfaceSiteId = m_strInterfaceSiteId;
		this.m_strInterfaceClientId = m_strInterfaceClientId;
		this.m_nInterfaceExpirationSecs = m_nInterfaceExpirationSecs;
		this.m_nInterfaceTimeOutSecs = m_nInterfaceTimeOutSecs;
		this.m_bBenchmarkMode = m_bBenchmarkMode;
		this.m_bSSOMode = m_bSSOMode;
	}
	public DCSRequest() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the m_strSessionId
	 */
	public String getM_strSessionId() {
		return m_strSessionId;
	}
	/**
	 * @param m_strSessionId the m_strSessionId to set
	 */
	public void setM_strSessionId(String m_strSessionId) {
		this.m_strSessionId = m_strSessionId;
	}
	/**
	 * @return the m_nCheckSum
	 */
	public int getM_nCheckSum() {
		return m_nCheckSum;
	}
	/**
	 * @param m_nCheckSum the m_nCheckSum to set
	 */
	public void setM_nCheckSum(int m_nCheckSum) {
		this.m_nCheckSum = m_nCheckSum;
	}
	/**
	 * @return the m_nTraceLevel
	 */
	public int getM_nTraceLevel() {
		return m_nTraceLevel;
	}
	/**
	 * @param m_nTraceLevel the m_nTraceLevel to set
	 */
	public void setM_nTraceLevel(int m_nTraceLevel) {
		this.m_nTraceLevel = m_nTraceLevel;
	}
	/**
	 * @return the m_strSessionType
	 */
	public String getM_strSessionType() {
		return m_strSessionType;
	}
	/**
	 * @param m_strSessionType the m_strSessionType to set
	 */
	public void setM_strSessionType(String m_strSessionType) {
		this.m_strSessionType = m_strSessionType;
	}
	/**
	 * @return the m_strUserId
	 */
	public String getM_strUserId() {
		return m_strUserId;
	}
	/**
	 * @param m_strUserId the m_strUserId to set
	 */
	public void setM_strUserId(String m_strUserId) {
		this.m_strUserId = m_strUserId;
	}
	/**
	 * @return the m_strUserGroup
	 */
	public String getM_strUserGroup() {
		return m_strUserGroup;
	}
	/**
	 * @param m_strUserGroup the m_strUserGroup to set
	 */
	public void setM_strUserGroup(String m_strUserGroup) {
		this.m_strUserGroup = m_strUserGroup;
	}
	/**
	 * @return the m_bUsingHostName
	 */
	public boolean isM_bUsingHostName() {
		return m_bUsingHostName;
	}
	/**
	 * @param m_bUsingHostName the m_bUsingHostName to set
	 */
	public void setM_bUsingHostName(boolean m_bUsingHostName) {
		this.m_bUsingHostName = m_bUsingHostName;
	}
	/**
	 * @return the m_strStationId
	 */
	public String getM_strStationId() {
		return m_strStationId;
	}
	/**
	 * @param m_strStationId the m_strStationId to set
	 */
	public void setM_strStationId(String m_strStationId) {
		this.m_strStationId = m_strStationId;
	}
	/**
	 * @return the m_strIPAddress
	 */
	public String getM_strIPAddress() {
		return m_strIPAddress;
	}
	/**
	 * @param m_strIPAddress the m_strIPAddress to set
	 */
	public void setM_strIPAddress(String m_strIPAddress) {
		this.m_strIPAddress = m_strIPAddress;
	}
	/**
	 * @return the m_strStationGroup
	 */
	public String getM_strStationGroup() {
		return m_strStationGroup;
	}
	/**
	 * @param m_strStationGroup the m_strStationGroup to set
	 */
	public void setM_strStationGroup(String m_strStationGroup) {
		this.m_strStationGroup = m_strStationGroup;
	}
	/**
	 * @return the m_strLanguage
	 */
	public String getM_strLanguage() {
		return m_strLanguage;
	}
	/**
	 * @param m_strLanguage the m_strLanguage to set
	 */
	public void setM_strLanguage(String m_strLanguage) {
		this.m_strLanguage = m_strLanguage;
	}
	/**
	 * @return the m_strFunctionId
	 */
	public String getM_strFunctionId() {
		return m_strFunctionId;
	}
	/**
	 * @param m_strFunctionId the m_strFunctionId to set
	 */
	public void setM_strFunctionId(String m_strFunctionId) {
		this.m_strFunctionId = m_strFunctionId;
	}
	/**
	 * @return the m_strTimeZoneName
	 */
	public String getM_strTimeZoneName() {
		return m_strTimeZoneName;
	}
	/**
	 * @param m_strTimeZoneName the m_strTimeZoneName to set
	 */
	public void setM_strTimeZoneName(String m_strTimeZoneName) {
		this.m_strTimeZoneName = m_strTimeZoneName;
	}
	/**
	 * @return the m_strNlsCalendar
	 */
	public String getM_strNlsCalendar() {
		return m_strNlsCalendar;
	}
	/**
	 * @param m_strNlsCalendar the m_strNlsCalendar to set
	 */
	public void setM_strNlsCalendar(String m_strNlsCalendar) {
		this.m_strNlsCalendar = m_strNlsCalendar;
	}
	/**
	 * @return the m_strLocality
	 */
	public String getM_strLocality() {
		return m_strLocality;
	}
	/**
	 * @param m_strLocality the m_strLocality to set
	 */
	public void setM_strLocality(String m_strLocality) {
		this.m_strLocality = m_strLocality;
	}
	/**
	 * @return the m_bSqlTracing
	 */
	public boolean isM_bSqlTracing() {
		return m_bSqlTracing;
	}
	/**
	 * @param m_bSqlTracing the m_bSqlTracing to set
	 */
	public void setM_bSqlTracing(boolean m_bSqlTracing) {
		this.m_bSqlTracing = m_bSqlTracing;
	}
	/**
	 * @return the m_nRequestAction
	 */
	public int getM_nRequestAction() {
		return m_nRequestAction;
	}
	/**
	 * @param m_nRequestAction the m_nRequestAction to set
	 */
	public void setM_nRequestAction(int m_nRequestAction) {
		this.m_nRequestAction = m_nRequestAction;
	}
	/**
	 * @return the m_object
	 */
	public Object getM_object() {
		return m_object;
	}
	/**
	 * @param m_object the m_object to set
	 */
	public void setM_object(Object m_object) {
		this.m_object = m_object;
	}
	/**
	 * @return the m_bInterfaceTestMode
	 */
	public boolean isM_bInterfaceTestMode() {
		return m_bInterfaceTestMode;
	}
	/**
	 * @param m_bInterfaceTestMode the m_bInterfaceTestMode to set
	 */
	public void setM_bInterfaceTestMode(boolean m_bInterfaceTestMode) {
		this.m_bInterfaceTestMode = m_bInterfaceTestMode;
	}
	/**
	 * @return the m_strInterfaceOracleDateFormat
	 */
	public String getM_strInterfaceOracleDateFormat() {
		return m_strInterfaceOracleDateFormat;
	}
	/**
	 * @param m_strInterfaceOracleDateFormat the m_strInterfaceOracleDateFormat to set
	 */
	public void setM_strInterfaceOracleDateFormat(String m_strInterfaceOracleDateFormat) {
		this.m_strInterfaceOracleDateFormat = m_strInterfaceOracleDateFormat;
	}
	/**
	 * @return the m_strInterfaceJavaDateFormat
	 */
	public String getM_strInterfaceJavaDateFormat() {
		return m_strInterfaceJavaDateFormat;
	}
	/**
	 * @param m_strInterfaceJavaDateFormat the m_strInterfaceJavaDateFormat to set
	 */
	public void setM_strInterfaceJavaDateFormat(String m_strInterfaceJavaDateFormat) {
		this.m_strInterfaceJavaDateFormat = m_strInterfaceJavaDateFormat;
	}
	/**
	 * @return the m_strInterfaceAuthenticationKey
	 */
	public String getM_strInterfaceAuthenticationKey() {
		return m_strInterfaceAuthenticationKey;
	}
	/**
	 * @param m_strInterfaceAuthenticationKey the m_strInterfaceAuthenticationKey to set
	 */
	public void setM_strInterfaceAuthenticationKey(String m_strInterfaceAuthenticationKey) {
		this.m_strInterfaceAuthenticationKey = m_strInterfaceAuthenticationKey;
	}
	/**
	 * @return the m_strInterfaceType
	 */
	public String getM_strInterfaceType() {
		return m_strInterfaceType;
	}
	/**
	 * @param m_strInterfaceType the m_strInterfaceType to set
	 */
	public void setM_strInterfaceType(String m_strInterfaceType) {
		this.m_strInterfaceType = m_strInterfaceType;
	}
	/**
	 * @return the m_strInterfaceIdentifier
	 */
	public String getM_strInterfaceIdentifier() {
		return m_strInterfaceIdentifier;
	}
	/**
	 * @param m_strInterfaceIdentifier the m_strInterfaceIdentifier to set
	 */
	public void setM_strInterfaceIdentifier(String m_strInterfaceIdentifier) {
		this.m_strInterfaceIdentifier = m_strInterfaceIdentifier;
	}
	/**
	 * @return the m_strInterfacePassword
	 */
	public String getM_strInterfacePassword() {
		return m_strInterfacePassword;
	}
	/**
	 * @param m_strInterfacePassword the m_strInterfacePassword to set
	 */
	public void setM_strInterfacePassword(String m_strInterfacePassword) {
		this.m_strInterfacePassword = m_strInterfacePassword;
	}
	/**
	 * @return the m_strInterfaceReferenceId
	 */
	public String getM_strInterfaceReferenceId() {
		return m_strInterfaceReferenceId;
	}
	/**
	 * @param m_strInterfaceReferenceId the m_strInterfaceReferenceId to set
	 */
	public void setM_strInterfaceReferenceId(String m_strInterfaceReferenceId) {
		this.m_strInterfaceReferenceId = m_strInterfaceReferenceId;
	}
	/**
	 * @return the m_strInterfaceSiteId
	 */
	public String getM_strInterfaceSiteId() {
		return m_strInterfaceSiteId;
	}
	/**
	 * @param m_strInterfaceSiteId the m_strInterfaceSiteId to set
	 */
	public void setM_strInterfaceSiteId(String m_strInterfaceSiteId) {
		this.m_strInterfaceSiteId = m_strInterfaceSiteId;
	}
	/**
	 * @return the m_strInterfaceClientId
	 */
	public String getM_strInterfaceClientId() {
		return m_strInterfaceClientId;
	}
	/**
	 * @param m_strInterfaceClientId the m_strInterfaceClientId to set
	 */
	public void setM_strInterfaceClientId(String m_strInterfaceClientId) {
		this.m_strInterfaceClientId = m_strInterfaceClientId;
	}
	/**
	 * @return the m_nInterfaceExpirationSecs
	 */
	public int getM_nInterfaceExpirationSecs() {
		return m_nInterfaceExpirationSecs;
	}
	/**
	 * @param m_nInterfaceExpirationSecs the m_nInterfaceExpirationSecs to set
	 */
	public void setM_nInterfaceExpirationSecs(int m_nInterfaceExpirationSecs) {
		this.m_nInterfaceExpirationSecs = m_nInterfaceExpirationSecs;
	}
	/**
	 * @return the m_nInterfaceTimeOutSecs
	 */
	public int getM_nInterfaceTimeOutSecs() {
		return m_nInterfaceTimeOutSecs;
	}
	/**
	 * @param m_nInterfaceTimeOutSecs the m_nInterfaceTimeOutSecs to set
	 */
	public void setM_nInterfaceTimeOutSecs(int m_nInterfaceTimeOutSecs) {
		this.m_nInterfaceTimeOutSecs = m_nInterfaceTimeOutSecs;
	}
	/**
	 * @return the m_bBenchmarkMode
	 */
	public boolean isM_bBenchmarkMode() {
		return m_bBenchmarkMode;
	}
	/**
	 * @param m_bBenchmarkMode the m_bBenchmarkMode to set
	 */
	public void setM_bBenchmarkMode(boolean m_bBenchmarkMode) {
		this.m_bBenchmarkMode = m_bBenchmarkMode;
	}
	/**
	 * @return the m_bSSOMode
	 */
	public boolean isM_bSSOMode() {
		return m_bSSOMode;
	}
	/**
	 * @param m_bSSOMode the m_bSSOMode to set
	 */
	public void setM_bSSOMode(boolean m_bSSOMode) {
		this.m_bSSOMode = m_bSSOMode;
	}
	
}
