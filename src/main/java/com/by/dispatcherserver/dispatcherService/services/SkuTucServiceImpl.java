package com.by.dispatcherserver.dispatcherService.services;

import java.util.HashMap;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;
import com.by.dispatcherserver.dispatcherService.dcsconnectors.DCSRequestFactory;
import com.by.dispatcherserver.dispatcherService.dcslibrary.DCSRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.ExecuteSelectRequest;
import com.by.dispatcherserver.dispatcherService.dcslibrary.GeneralConstant;
import com.by.dispatcherserver.dispatcherService.model.SKUTucDO;
import com.by.dispatcherserver.dispatcherService.util.SqlUtility;

@Service
public class SkuTucServiceImpl implements ISkuTucService {
	@Autowired
	HttpResponse httpResp;

	@Autowired
	DCSRequestFactory reqfactory;

	@Override
	public HttpResponse getSkuTuc(HashMap<String, Object> SkuTucDetails) {
		SqlUtility<SKUTucDO> util = new SqlUtility<>(SkuTucDetails, SKUTucDO.class);
		StringBuffer strbufSQL = util.getSQLQuery();

		ExecuteSelectRequest l_executeRequest = new ExecuteSelectRequest(strbufSQL.toString(), 1000, -1, null);
		DCSRequest p_request = new DCSRequest("1Bm0yP41lbYgHMkG", 0, 3, null, "SUPPORT", "admin", false, "IN21019092LT", "172.16.72.1",
				"WEB", "EN_GB", null, null, null, null, false, 0/* requst action */, l_executeRequest, false, "", "",
				"", "", "", "", "", "", "", 0, 0, false, false);
		Vector<Vector<String>> m_vctResults = null;
		Vector<String> m_vctColumns;
		// JSONArray jsonarr = new JSONArray(m_vctResults);
		// convert vector to json
		return reqfactory.getDCSRequestExecuted(GeneralConstant.c_EJBReqActConExecuteSelect, p_request);

	}

}
