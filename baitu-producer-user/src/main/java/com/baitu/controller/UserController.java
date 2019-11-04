package com.baitu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baitu.entity.BtUser;
import com.baitu.service.UserService;

/**
 * @author renhuibo  2019-11-01 01:34:48
 * @Description
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/info")
	public BtUser userInfo(String userId) {
		System.out.println("user-rev："+userId);
		return userService.userInfo(userId);
	}
}
