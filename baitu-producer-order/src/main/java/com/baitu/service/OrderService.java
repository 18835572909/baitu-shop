package com.baitu.service;

import com.baitu.entity.BtOrder;

/**
 * @author renhuibo  2019-11-01 01:24:43
 * @Description
 */
public interface OrderService {
	
	/**
	 * @author renhuibo  2019年11月1日
	 * @Description 获取订单信息
	 */
	public BtOrder orderInfo(String orderCode);
	
	/**
	 * @author renhuibo  2019年11月2日
	 * @Description 生成订单
	 */
	public BtOrder saveOrder(BtOrder order);
}
