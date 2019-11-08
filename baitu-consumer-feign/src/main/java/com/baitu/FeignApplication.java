package com.baitu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author renhuibo  2019-11-06 21:32:11
 * @Description
 */
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class FeignApplication {
	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}
}
