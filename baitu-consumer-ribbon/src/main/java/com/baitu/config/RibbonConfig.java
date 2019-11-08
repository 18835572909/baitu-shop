package com.baitu.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author renhuibo  2019-11-02 02:04:37
 * @Description
 */
@Component
public class RibbonConfig {

	//注入RestTemplate,自动配置Ribbon
	@Bean
	//开启Ribbon的客户端负载
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
