package com.baitu.service.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import com.baitu.entity.BtUser;
import com.baitu.service.UserService;

/**
 * @author renhuibo  2019-11-01 01:28:37
 * @Description
 */
@Service
public class UserServiceImpl implements UserService{

	@Override
	public BtUser userInfo(String userId) {
		BtUser user = new BtUser();
		user.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setUsername("系统用户");
		user.setUsercode("admin");
		user.setPassword("admin");
		return user;
	}
	
}
