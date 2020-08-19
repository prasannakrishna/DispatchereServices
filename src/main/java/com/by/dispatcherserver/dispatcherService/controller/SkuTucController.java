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
import com.by.dispatcherserver.dispatcherService.model.SKUTucDO;
import com.by.dispatcherserver.dispatcherService.services.ISkuTucService;
import com.by.dispatcherserver.dispatcherService.services.InventoryserviceImpl;
import com.by.dispatcherserver.dispatcherService.services.SKUserviceImpl;
import com.by.dispatcherserver.dispatcherService.services.SkuTucServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/skutuc")
public class SkuTucController {
	@Autowired
	@Lazy
	SkuTucServiceImpl SkuTucService;

	@PostMapping(value = "/getSkuTucdetails", consumes = "application/json", produces ="application/json")
	public HttpResponse getSkuTucDtails(@RequestBody SKUTucDO skuTucDetails) {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> mapinv = mapper.convertValue(skuTucDetails, new TypeReference<Map<String, Object>>() {
		});
		while (mapinv.values().remove(null));
		return SkuTucService.getSkuTuc((HashMap<String, Object>) mapinv);
	}
}
