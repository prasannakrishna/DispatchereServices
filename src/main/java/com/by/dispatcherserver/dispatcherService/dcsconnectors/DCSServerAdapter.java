package com.by.dispatcherserver.dispatcherService.dcsconnectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.by.dispatcherserver.dispatcherService.dcslibrary.BindVariableData;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSResponse;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ExecuteSelectRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.GeneralConstant;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ServerResultSet;

//this will call home after marshalling all request to dcs request and dcsresponse 
@Component
public class DCSServerAdapter {
	@Autowired
	DCSHome dcshome;

	public ServerResultSet executeSelect(String p_strSql, int p_noOfColumns, int p_noOfRows, boolean p_bPersistent,
			int p_intBlobColumn, BindVariableData p_bindVariables, DCSRequest p_request) throws Exception {
		// m_sessionManager.outputClientTraceInfo(GeneralConstant.c_LoggingLevelInfo,
		// "ClientEJB.executeSelect() - start");
		DCSResponse l_response = null;

		// Setup request
		p_request.m_nRequestAction = GeneralConstant.c_EJBReqActConExecuteSelect;

		ExecuteSelectRequest l_executeRequest = new ExecuteSelectRequest(p_strSql, p_noOfRows, p_intBlobColumn,
				p_bindVariables);

		p_request.m_object = l_executeRequest;

		// Make request
		l_response = dcshome.processRequest(p_request);

		// Process response
		/*
		 * if (l_response.m_bSuccess == false) { throw new Exception("WSM00003"); }
		 */

		// Return results
		return (ServerResultSet) l_response.m_object;
	}

}
