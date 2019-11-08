package com.baitu.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.baitu.entity.BtOrder;

@RequestMapping("/refactor")
public interface OrderService {
	
	@RequestMapping("/order/info")
	public BtOrder orderInfo(@RequestParam(name="orderCode") String orderCode);
	
	@PostMapping("/order/save")
	public BtOrder saveOrder(@RequestBody BtOrder order);
	
	
}
