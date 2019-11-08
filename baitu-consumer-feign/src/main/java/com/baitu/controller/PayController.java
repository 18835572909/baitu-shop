package com.baitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baitu.common.APIResponse;
import com.baitu.service.PayOrderService;
import com.baitu.service.provider.OrderService;

/**
 * @author renhuibo  2019-11-06 23:11:23
 * @Description
 */
@RestController
@RequestMapping("/pay")
public class PayController {
	
	@Autowired
	private PayOrderService payOrderService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order")
	public APIResponse payOrder(String orderCode,double orderMoney) {
		return payOrderService.pay(orderCode,orderMoney);
	}
	
	@RequestMapping("/orderinfo")
	public APIResponse orderInfo(String orderCode) {
		return APIResponse.instance(orderService.orderInfo(orderCode));
	}
	
}
