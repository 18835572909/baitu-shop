package com.baitu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baitu.common.APIResponse;
import com.baitu.entity.BtOrder;
import com.baitu.service.PayOrderService;
import com.baitu.service.provider.OrderService;

/**
 * @author renhuibo  2019-11-06 22:40:07
 * @Description
 */

@Service
public class PayOrderServiceImpl implements PayOrderService {
	
	@Autowired
	private OrderService orderService;
	
	@Override
	public APIResponse pay(String orderCode,double orderMoney) {
		BtOrder orderInfo = orderService.orderInfo(orderCode);
		orderInfo.setOrderMoney(orderMoney);
		orderInfo.setOrderStatus(1);
		System.out.println("orderInfo: "+orderInfo);
		return APIResponse.instance(orderService.saveOrder(orderInfo));
	}

}
