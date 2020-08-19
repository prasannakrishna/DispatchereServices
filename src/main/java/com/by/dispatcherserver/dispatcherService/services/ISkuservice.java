package com.by.dispatcherserver.dispatcherService.services;

import java.util.HashMap;
import java.util.Map;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;

public interface ISkuservice {

	public HttpResponse modifySKU(HashMap<String, String> p_mpInvFields);

	public HttpResponse deleteSKU(HashMap<String, String> p_mpInvFields);

	public HttpResponse getSKU(Map<String, Object> invDetails);

	public HttpResponse createSKU(Map<String, Object> invDetails);

}
