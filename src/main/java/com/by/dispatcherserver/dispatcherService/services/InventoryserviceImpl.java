package com.by.dispatcherserver.dispatcherService.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;
import com.by.dispatcherserver.dispatcherService.dcsconnectors.DCSRequestFactory;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ExecuteSelectRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.GeneralConstant;
import com.by.dispatcherserver.dispatcherService.model.InventoryDO;
import com.by.dispatcherserver.dispatcherService.util.SqlUtility;

@Service
public class InventoryserviceImpl implements IInventoryservice {

	@Autowired
	HttpResponse httpResp;

	@Autowired
	DCSRequestFactory reqfactory;

	@Override
	public HttpResponse deleteInventory(HashMap<String, String> p_mpInvFields) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse getInventory(HashMap<String, Object> invDetails) {
		// call adpter with dcsrequest

		SqlUtility<InventoryDO> util = new SqlUtility<>(invDetails, InventoryDO.class);
		StringBuffer strbufSQL = util.getSQLQuery();
		DCSRequest p_request = new DCSRequest();

		ExecuteSelectRequest l_executeRequest = new ExecuteSelectRequest(strbufSQL.toString(), 1000, -1, null);
		p_request.m_object = l_executeRequest;
		 Vector<Vector<String>> m_vctResults = null;
		  Vector<String> m_vctColumns;
		//JSONArray jsonarr = new JSONArray(m_vctResults);
		// convert vector to json
		return reqfactory.getDCSRequestExecuted(GeneralConstant.c_EJBReqActConExecuteSelect, p_request);
	}

	@Override
	public HttpResponse createInventory(Map<String, Object> invDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse modifyInvenetory(HashMap<String, String> p_mpInvFields) {
		// TODO Auto-generated method stub
		return null;
	}

}
