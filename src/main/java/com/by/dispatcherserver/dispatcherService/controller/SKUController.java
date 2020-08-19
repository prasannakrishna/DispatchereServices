package com.by.dispatcherserver.dispatcherService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;
import com.by.dispatcherserver.dispatcherService.services.SKUserviceImpl;

public class SKUController {
	@Autowired
	SKUserviceImpl SKUService;
	private HashMap<String, String> p_mpInvFields;

	@PostMapping(value = "/getskudetails.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpResponse getInventoryDetails(@RequestBody Map<String, Object> SKUDetails) {
		return SKUService.getSKU(SKUDetails);
	}

	@PostMapping(value = "/addskudetails.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpResponse addInventory(@RequestBody Map<String, Object> SKUDetails) {
		return SKUService.createSKU(SKUDetails);
	}
}
