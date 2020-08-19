package com.by.dispatcherserver.dispatcherService.dcsconnectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;
import com.by.dispatcherserver.dispatcherService.dcslibrary.BindVariableData;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ExecuteSelectRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.GeneralConstant;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ServerResultSet;

// this factory is responsible to create DCSRequest based on action with httprequest
@Component
public class DCSRequestFactory implements GeneralConstant {
	private boolean p_bPersistent;
	private BindVariableData p_bindVariables;
	@Autowired
	DCSServerAdapter serveradapter;
	private HttpResponse l_response;

	public HttpResponse getDCSRequestExecuted(int p_action, DCSRequest p_request) {

		if (p_action <= c_EJBReqTypeConnection) {
			// Run connection request

			switch (p_action) {
			case c_EJBReqActConExecuteSelect:
				ExecuteSelectRequest req = (ExecuteSelectRequest) p_request.getM_object();
				String p_strSql = (String) req.getSQL();
				int p_noOfColumns = 8;
				int p_noOfRows = 1000;
				int p_intBlobColumn = 0;
				ServerResultSet l_response;

				try {
					l_response = serveradapter.executeSelect(p_strSql, p_noOfColumns, p_noOfRows, p_bPersistent,
							p_intBlobColumn, p_bindVariables, p_request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			default:
				// Invalid connection request
				// m_logger.outputTraceInfo(c_LoggingLevelError, "ClientEJBBean.runRequest() -
				// invalid connection request action " + p_request.m_nRequestAction);
				// l_response = new DCSResponse();
				// l_response.m_bSuccess = false;
				// l_response.m_strErrorCode = "WSM01009";
				break;
			}
		} else if (p_action <= c_EJBReqTypeOperation) {
			// Check have access to operation requests

			// Run operation request

			switch (p_action) {

			case c_EJBReqActOpsExecuteStatement:
				// l_response = l_operation.executeStatement(p_request);
				break;

			case c_EJBReqActOpsExecuteTransaction:
				// l_response = l_operation.executeTransaction(p_request);
				break;

			case c_EJBReqActOpsExecuteOperation:
				// l_response = l_operation.executeOperation(p_request);
				break;

			default:
				// Invalid operation request
				// m_logger.outputTraceInfo(c_LoggingLevelError, "ClientEJBBean.runRequest() -
				// invalid operation request action " + p_request.m_nRequestAction);
				// l_response = new DCSResponse();
				// l_response.m_bSuccess = false;
				// l_response.m_strErrorCode = "WSM01011";
				break;
			}
		}

		// Catch all for possible problems

		return l_response;
	}
}
