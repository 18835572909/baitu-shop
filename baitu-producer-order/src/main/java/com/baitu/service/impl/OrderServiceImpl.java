package com.baitu.service.impl;

import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.baitu.entity.BtOrder;
import com.baitu.service.OrderService;

/**
 * @author renhuibo  2019-11-01 01:28:37
 * @Description
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public BtOrder orderInfo(String orderCode) {
		System.out.println("order-->"+orderCode);
		
		BtOrder order = new BtOrder();
		order.setOrderCode(UUID.randomUUID().toString().replaceAll("-", "")+"-9001");
		order.setOrderTime(new Date());
		return order;
	}

	@Override
	public BtOrder saveOrder(BtOrder order) {
		return order;
	}
	
}
