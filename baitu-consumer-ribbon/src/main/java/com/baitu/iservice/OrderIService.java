package com.baitu.iservice;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.baitu.entity.BtOrder;

/**
 * @author renhuibo  2019-11-02 02:57:49
 * @Description
 */
@Service
public class OrderIService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	private static final String ORDER_SERVICE = "baitu-order-service";
	private static final String ORDER_SERVICE_IP="192.168.1.102";
	private static final Integer ORDER_SERVICE_PORT=9001;
	
	/**
	 * @author renhuibo  2019年11月2日
	 * @Description 完全是HttpClient发出请求
	 */
	public BtOrder method1() {
		BtOrder order = 
				restTemplate.getForObject("http://"+ORDER_SERVICE_IP+":"+ORDER_SERVICE_PORT+"/orders/info?orderCode={1}", BtOrder.class, "order-1");
	
		return order;
	}
	
	/**
	 * @author renhuibo  2019年11月2日
	 * @Description 利用RestTemplate和服务名请求
	 */
	public BtOrder method2() {
		ResponseEntity<BtOrder> responseEntity = 
				restTemplate.getForEntity("http://"+ORDER_SERVICE+"/orders/info?orderCode={1}", BtOrder.class,"order-2");
		
		BtOrder order = responseEntity.getBody();
		
		return order;
	}
	
	/**
	 * @author renhuibo  2019年11月2日
	 * @Description 利用服务实例获取服务ip和端口，发送请求
	 */
	public BtOrder method3() {
		ServiceInstance serviceInstance = loadBalancerClient.choose(ORDER_SERVICE);
		String url = String.format("http://%s:%d/orders/info?orderCode={1}",serviceInstance.getHost(),serviceInstance.getPort());
		
		RestTemplate template = new RestTemplate();
		BtOrder order = template.getForObject(url, BtOrder.class, "order-3");
		
		return order;
	}
	
	public BtOrder getMethod() {
		/*
		 * 常用方法：
		 * 	1. getForEntity():  返回ResponseEntity对象，包含完整http请求信息
		 * 	2. getForObject():  返回Object对象，只包含body中信息。 
		 */
		
		/*
		restTemplate.getForObject(url, responseType);
		restTemplate.getForObject(url, responseType, uriVariables);
		restTemplate.getForObject(url, responseType, uriVariables);
		restTemplate.getForEntity(url, responseType);
		restTemplate.getForEntity(url, responseType, uriVariables);
		restTemplate.getForEntity(url, responseType, uriVariables);
		*/
		//map传参和httpclient有所区别，要特别注意。个人觉的这个改变有点鸡肋
		Map<String, Object> params = new HashMap<>();
		params.put("orderCode", "888");
		BtOrder order = restTemplate.getForObject("http://"+ORDER_SERVICE+"/orders/info?orderCode={orderCode}", BtOrder.class, params);
		
		//参数拼接
		restTemplate.getForObject("http://"+ORDER_SERVICE+"/orders/info?orderCode={1}", BtOrder.class, "123456");
		
		//uri方法
		UriComponents uriComponents = UriComponentsBuilder
				.fromUriString("http://"+ORDER_SERVICE+"/orders/info?orderCode={1}")
				.build()
				.expand("666")
				.encode();
		URI uri = uriComponents.toUri();
		restTemplate.getForObject(uri, BtOrder.class);
		
		return order;
	}
	
	public BtOrder postMethod() {
		/*
		 * 常用方法：与get方式不同的
		 * 	1. 多Object request参数。
		 * 
		 *  2. 多postForLocation方法。
		 */
		
		/*
		restTemplate.postForEntity(url, request, responseType);
		restTemplate.postForEntity(url, request, responseType, uriVariables);
		restTemplate.postForEntity(url, request, responseType, uriVariables);
		restTemplate.postForObject(url, request, responseType);
		restTemplate.postForObject(url, request, responseType, uriVariables);
		restTemplate.postForObject(url, request, responseType, uriVariables);
		restTemplate.postForLocation(url, request);
		restTemplate.postForLocation(url, request, uriVariables);
		restTemplate.postForLocation(url, request, uriVariables);
		*/
		BtOrder order = new BtOrder();
		order.setOrderCode(UUID.randomUUID().toString().replaceAll("-", ""));
		order.setOrderTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		return restTemplate.postForObject("http://"+ORDER_SERVICE+"/orders/save", order, BtOrder.class);
	}
}
