package com.baitu.service.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baitu.entity.BtOrder;

/**
 * @author renhuibo  2019-11-06 21:39:52
 * @Description
 */
@FeignClient("BAITU-ORDER-SERVICE")
public interface OrderService {

	@RequestMapping(value="/orders/info")
	public BtOrder orderInfo(@RequestParam(name="orderCode") String orderCode);
	
	@PostMapping(value="/orders/save")
	public BtOrder saveOrder(@RequestBody BtOrder order);
	
}
