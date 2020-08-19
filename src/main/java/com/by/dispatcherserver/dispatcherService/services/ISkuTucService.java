package com.by.dispatcherserver.dispatcherService.services;

import java.util.HashMap;

import com.by.dispatcherserver.dispatcherService.common.HttpResponse;

public interface ISkuTucService {

	HttpResponse getSkuTuc(HashMap<String, Object> SkuTucDetails);

}
