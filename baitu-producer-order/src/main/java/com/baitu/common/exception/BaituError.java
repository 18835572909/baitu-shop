package com.baitu.common.exception;

/**
 * @author renhuibo  2019-11-06 22:07:21
 * @Description
 */
public enum BaituError {

	SERVER_ERROR(20000,""),
	REQUEST_PARAM_ERROR(20001,"请求参数错误"),
	REQUEST_VALID_ERROR(20002,"参数验证失败"),
	REQUEST_BINGDING_ERROE(20003,"参数绑定失败"),
	REQUEST_VIOLATION_ERROR(20004,"参数验证失败"),
	REQUEST_404_ERROR(20005,"404-请求错误"),
	REQUEST_METHOD_ERROE(20006,"请求方式错误"),
	REQUEST_RESOURCE_ERROR(20007,"不支持当前媒体类型"),
	REQUEST_PARSING_ERROR(20008,"参数解析失败"),
	BAITU_ERROE(20100,"程序主动抛出异常")
	;
	
	
	private int code;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private BaituError(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
