package com.baitu.service;

import com.baitu.common.APIResponse;

/**
 * @author renhuibo  2019-11-06 21:42:30
 * @Description
 */
public interface PayOrderService {
	
	public APIResponse pay(String orderCode,double orderMoney);
	
}
