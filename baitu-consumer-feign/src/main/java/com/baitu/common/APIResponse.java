package com.baitu.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author renhuibo  2019-11-06 21:44:00
 * @Description 公共相应模板类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class APIResponse {
	
	private int code;
	
	private String message;
	
	private Object data;
	
	public static APIResponse instance(int code,String message,Object data) {
		return new APIResponse(code, message, data);
	}
	
	public static APIResponse instance(Object data) {
		return new APIResponse(0, "请求成功！", data);
	}
	
	public static APIResponse instance(int code,String message) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setCode(code);
		apiResponse.setMessage(message);
		return apiResponse;
	}
}
