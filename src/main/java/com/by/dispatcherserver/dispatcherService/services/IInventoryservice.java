package com.by.dispatcherserver.dispatcherService.services;

import java.util.HashMap;
import java.util.Map;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;

public interface IInventoryservice {
	// public HttpResponse getInventory(HashMap<String, String> p_mpInvFields);

	public HttpResponse modifyInvenetory(HashMap<String, String> p_mpInvFields);

	public HttpResponse deleteInventory(HashMap<String, String> p_mpInvFields);

	HttpResponse createInventory(Map<String, Object> invDetails);

	HttpResponse getInventory(HashMap<String, Object> invDetails);

}
