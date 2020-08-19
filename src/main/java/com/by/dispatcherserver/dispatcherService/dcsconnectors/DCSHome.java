package com.by.dispatcherserver.dispatcherService.dcsconnectors;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSResponse;
import com.by.dispatcherserver.dispatcherService.dcslibrary.GeneralConstant;
import com.by.dispatcherserver.dispatcherService.dcsserver.ConnectionActions;
import com.by.dispatcherserver.dispatcherService.dcsserver.OperationActions;

// this class is responsible for calling make request of clientejbhome
@Component
public class DCSHome implements GeneralConstant {
	private DataSource m_dataSource = null;
	private Connection m_connection = null;

	@Autowired
	JdbcTemplate jdbctemplate;

	public DCSResponse processRequest(DCSRequest p_request) {
		DCSResponse l_response = null;

		// m_logger = new OutputLogger(m_strAppServerTypeValue,
		// p_request.m_strSessionId, p_request.m_nTraceLevel);

		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ClientEJBBean.processRequest() - started" + getMemoryUsedStart(p_request));

		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ClientEJBBean.processRequest() - using app server type " +
		// m_strAppServerTypeValue);

		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ClientEJBBean.processRequest() - using datasource value " +
		// m_strDataSourceValue);

		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ClientEJBBean.processRequest() - for session type " +
		// p_request.m_strSessionType);

		// Get database connection and marshal request
		try {
			// Get database connection
			// m_logger.outputTraceInfo(c_LoggingLevelInfo, "ClientEJBBean.processRequest()
			// - get connection");
			m_connection = jdbctemplate.getDataSource().getConnection();

			// Marshal request & get response
			// m_logger.outputTraceInfo(c_LoggingLevelInfo,
			// "ClientEJBBean.processRequest() - marshal request & get response");
			l_response = marshalRequest(p_request);

			// Turn off sql tracing (if turned on earlier)
			// if testmode true then already rollback called, check if test mode false,then
			// set sql tracing
			if (p_request.m_bInterfaceTestMode == false) {
				// setupSqlTracing(p_request);
			}
		} catch (Exception p_e) {
			// m_logger.outputStackTraceInfo(p_e);
			// l_response = createExceptionResponse("WSM01002A", p_e);
		} finally {
			try {
				// Close connection
				// m_logger.outputTraceInfo(c_LoggingLevelInfo, "ClientEJBBean.processRequest()
				// - close connection");
				m_connection.close();
			} catch (Exception p_e2) {
				// m_logger.outputStackTraceInfo(p_e2);
				// l_response = createExceptionResponse("WSM01002B", p_e2);
			}
		}

		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ClientEJBBean.processRequest() - ended" + getMemoryUsedEnd(p_request));

		return l_response;
	}

	private DCSResponse marshalRequest(DCSRequest p_request) {
		// m_logger.outputTraceInfo(c_LoggingLevelInfo,
		// "ClientEJBBean.marshalRequest() - start" + getMemoryUsed(p_request));
		DCSResponse l_response = null;

		// Configure session
		// l_response = configureSession(p_request);

		if (l_response != null) {
			// updateWebServiceLogRecord(p_request, l_response);
			return l_response;
		}

		// Check function access valid
		// l_response = checkFunctionAccess(p_request);

		if (l_response != null) {
			return l_response;
		}

		// Run request & get response
		l_response = runRequest(p_request);

		return l_response;
	}

	private DCSResponse runRequest(DCSRequest p_request) {
		//m_logger.outputTraceInfo(c_LoggingLevelInfo, "ClientEJBBean.runRequest() - start" + getMemoryUsed(p_request));
		DCSResponse l_response = null;

		// Descide whether connection or operation request
		//m_logger.outputTraceInfo(c_LoggingLevelInfo,
				//"ClientEJBBean.runRequest() - about to run request action " + p_request.m_nRequestAction);

		Object m_sessionContext = null;
		Object m_logger = null;
		if (p_request.m_nRequestAction <= c_EJBReqTypeConnection) {
			// Run connection request
			ConnectionActions l_connection = new ConnectionActions(m_sessionContext, m_connection, m_logger);

			switch (p_request.m_nRequestAction) {
			case c_EJBReqActConExecuteSelect:
				l_response = l_connection.executeSelect(p_request);
				break;

			case c_EJBReqActConUpdateApplicationSession:
				// l_response = l_connection.updateApplicationSession(p_request);
				break;

			case c_EJBReqActConPing:
				// l_response = l_connection.ping(p_request);
				break;

			case c_EJBReqActConGetIniSettings:
				// l_response = l_connection.getIniSettings(p_request);
				break;

			case c_EJBReqActConIsLanguageTextDownloadRequired:
				// l_response = l_connection.isLanguageTextDownloadRequired(p_request);
				break;

			case c_EJBReqActConIsTableSummaryDownloadRequired:
				// l_response = l_connection.isTableSummaryDownloadRequired(p_request);
				break;

			case c_EJBReqActConLoginUser:
				// l_response = l_connection.loginUser(p_request, m_bRequestFullAccess);
				break;

			case c_EJBReqActConGetLanguageText:
				// l_response = l_connection.getLanguageText(p_request);
				break;

			case c_EJBReqActConGetTableSummary:
				// l_response = l_connection.getTableSummary(p_request);
				break;

			case c_EJBReqActConDeleteApplicationSession:
				// l_response = l_connection.deleteApplicationSession(p_request);
				break;

			case c_EJBReqActConExecuteMultipleSelects:
				// l_response = l_connection.executeMultipleSelects(p_request);
				break;

			case c_EJBReqActConGetLoginScreenProperties:
				// l_response = l_connection.getLoginScreenProperties(p_request);
				break;

			default:
				// Invalid connection request
				// m_logger.outputTraceInfo(c_LoggingLevelError,
				// "ClientEJBBean.runRequest() - invalid connection request action " +
				// p_request.m_nRequestAction);
				l_response = new DCSResponse();
				l_response.m_bSuccess = false;
				l_response.m_strErrorCode = "WSM01009";
				break;
			}
		} else if (p_request.m_nRequestAction <= c_EJBReqTypeOperation) {
			boolean m_bRequestFullAccess = true;
			// Check have access to operation requests
			if (m_bRequestFullAccess == false) {
				// m_logger.outputTraceInfo(c_LoggingLevelError,
				// "ClientEJBBean.runRequest() - cannot have full access for operation request
				// action "
				// + p_request.m_nRequestAction);
				l_response = new DCSResponse();
				l_response.m_bSuccess = false;
				l_response.m_strErrorCode = "WSM01010";
				return l_response;
			}

			// Run operation request
			OperationActions l_operation = new OperationActions(m_sessionContext, m_connection, m_logger);

			switch (p_request.m_nRequestAction) {
			case c_EJBReqActOpsGetDateTime:
				// l_response = l_operation.getDateTime(p_request);
				break;

			case c_EJBReqActOpsGetGlobalFunctionAccess:
				// l_response = l_operation.getGlobalFunctionAccess(p_request);
				break;

			case c_EJBReqActOpsGetLocalFunctionAccess:
				// l_response = l_operation.getLocalFunctionAccess(p_request);
				break;

			case c_EJBReqActOpsGetSessionSetting:
				// l_response = l_operation.getSessionSetting(p_request);
				break;

			case c_EJBReqActOpsExecuteStatement:
				// l_response = l_operation.executeStatement(p_request);
				break;

			case c_EJBReqActOpsExecuteTransaction:
				l_response = l_operation.executeTransaction(p_request);
				break;

			case c_EJBReqActOpsExecuteOperation:
				// l_response = l_operation.executeOperation(p_request);
				break;

			case c_EJBReqActOpsGetKey:
				// l_response = l_operation.getKey(p_request);
				break;

			case c_EJBReqActOpsSetSessionSetting:
				// l_response = l_operation.setSessionSetting(p_request);
				break;

			case c_EJBReqActOpsRemoveSessionSettings:
				// l_response = l_operation.removeSessionSettings(p_request);
				break;

			case c_EJBReqActOpsChangePassword:
				// l_response = l_operation.changePassword(p_request);
				break;

			case c_EJBReqActOpsValidatePassword:
				// l_response = l_operation.validatePassword(p_request);
				break;

			case c_EJBReqActOpsLogoutUser:
				// l_response = l_operation.logoutUser(p_request);
				break;

			case c_EJBReqActOpsGetMenuGlobalAccesses:
				// l_response = l_operation.getMenuGlobalAccesses(p_request);
				break;

			case c_EJBReqActOpsExecuteMultipleStatements:
				// l_response = l_operation.executeMultipleStatements(p_request);
				break;

			case c_EJBReqActOpsExecuteMultipleOperations:
				// l_response = l_operation.executeMultipleOperations(p_request);
				break;

			case c_EJBReqActOpsGetNavigatorMenuData:
				// l_response = l_operation.getNavigatorMenuData(p_request);
				break;

			default:
				// Invalid operation request
				// m_logger.outputTraceInfo(c_LoggingLevelError,
				// "ClientEJBBean.runRequest() - invalid operation request action " +
				// p_request.m_nRequestAction);
				l_response = new DCSResponse();
				l_response.m_bSuccess = false;
				l_response.m_strErrorCode = "WSM01011";
				break;
			}
		} else {
			// Run web service interface request
			// InterfaceActions l_interface = new InterfaceActions(m_sessionContext,
			// m_connection, m_logger);

			switch (p_request.m_nRequestAction) {
			case c_EJBReqActInterfaceMerge: {
				// l_response = l_interface.mergeInterfaceData(p_request);
				break;
			}

			case c_EJBReqActInterfaceExtract: {
				// l_response = l_interface.extractInterfaceData(p_request);
				break;
			}

			case c_EJBReqActInterfaceConfirm: {
				// l_response = l_interface.confirmInterfaceData(p_request);
				break;
			}

			case c_EJBReqActInterfaceSelect: {
				// l_response = l_interface.runUserQuery(p_request);
				break;
			}

			case c_EJBReqActInterfaceMethod: {
				// l_response = l_interface.methodPackageCall(p_request);
				break;
			}

			default: {
				// Invalid interface request
				// m_logger.outputTraceInfo(c_LoggingLevelError,
				// "ClientEJBBean.runRequest() - invalid interface request action " +
				// p_request.m_nRequestAction);
				l_response = new DCSResponse();
				l_response.m_bSuccess = false;
				l_response.m_strErrorCode = "WSM01049";
				break;
			}
			}

			// Update the web services logging record with the results (if applicable)
			// updateWebServiceLogRecord(p_request, l_response);

			// If in test mode or transaction failed then rollback
			if (p_request.m_bInterfaceTestMode == true || l_response.m_bInterfaceRollback == true) {
				// m_sessionContext.setRollbackOnly();
			}
		}

		// Catch all for possible problems
		if (l_response == null) {
			// m_logger.outputTraceInfo(c_LoggingLevelError,
			// "ClientEJBBean.runRequest() - response not found when expected");
			l_response = new DCSResponse();
			l_response.m_bSuccess = false;
			l_response.m_strErrorCode = "WSM01012";
		}

		return l_response;
	}

}
