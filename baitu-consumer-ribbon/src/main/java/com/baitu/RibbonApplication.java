package com.baitu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author renhuibo  2019-11-01 02:01:40
 * @Description
 * 
 */
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
}
