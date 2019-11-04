package com.baitu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author renhuibo  2019-11-01 02:01:40
 * @Description
 * 	注解的理解： 在eurake-client的基础上，添加服务发现的功能
 * 
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class RecordApplication {
	public static void main(String[] args) {
		SpringApplication.run(RecordApplication.class, args);
	}
}
