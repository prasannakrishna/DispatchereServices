package com.by.dispatcherserver.dispatcherService.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;
import com.by.dispatcherserver.dispatcherService.model.InventoryDO;
import com.by.dispatcherserver.dispatcherService.services.InventoryserviceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	@Lazy
	InventoryserviceImpl InvService;

	@PostMapping(value = "/getinvdetails", consumes = "application/json")
	public HttpResponse getInventoryDetails(@RequestBody InventoryDO invDetails) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& hit");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> mapinv = mapper.convertValue(invDetails, new TypeReference<Map<String, Object>>() {
		});
		return InvService.getInventory((HashMap<String, Object>) mapinv);
	}

	//@PostMapping(value = "/addinvdetails.do", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HttpResponse addInventory(@RequestBody InventoryDO invDetails) {

		// return InvService.createInventory(invDetails);
		return null;
	}
}
