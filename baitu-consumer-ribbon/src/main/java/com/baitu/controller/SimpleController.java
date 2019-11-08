package com.baitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baitu.entity.BtOrder;
import com.baitu.iservice.OrderIService;

/**
 * @author renhuibo  2019-11-02 02:03:43
 * @Description
 */
@RestController
@RequestMapping("/ribbon")
public class SimpleController {
	
	@Autowired
	private OrderIService orderService;
	
	@RequestMapping("/method1")
	public BtOrder method1() {
		return orderService.method1();
	}
	
	@RequestMapping("/method2")
	public BtOrder method2() {
		return orderService.method2();
	}

	@RequestMapping("/method3")
	public BtOrder method3() {
		return orderService.method3();
	}
	
	@RequestMapping("/get")
	public BtOrder get() {
		return orderService.getMethod();
	}
	
	@RequestMapping("/post")
	public BtOrder post() {
		return orderService.postMethod();
	}
}
