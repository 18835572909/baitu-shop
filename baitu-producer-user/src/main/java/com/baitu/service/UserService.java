package com.baitu.service;

import com.baitu.entity.BtUser;

/**
 * @author renhuibo  2019-11-01 01:24:43
 * @Description
 */
public interface UserService {
	
	/**
	 * @author renhuibo  2019年11月1日
	 * @Description 获取用户信息
	 */
	public BtUser userInfo(String userId);
	
}
