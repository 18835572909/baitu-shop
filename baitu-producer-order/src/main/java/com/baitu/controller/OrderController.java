package com.baitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baitu.entity.BtOrder;
import com.baitu.service.OrderService;

/**
 * @author renhuibo  2019-11-01 01:34:48
 * @Description
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/info")
	public BtOrder userInfo(@RequestParam(name="orderCode") String orderCode) {
		System.out.println("order-rev："+orderCode);
		return orderService.orderInfo(orderCode);
	}
	
	@PostMapping("/save")
	public BtOrder saveOrder(@RequestBody BtOrder order) {
		return orderService.saveOrder(order);
	}
}
