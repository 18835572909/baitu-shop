package com.baitu.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author renhuibo  2019-11-06 21:52:56
 * @Description
 */
@Getter
@Setter
public class BaituException extends RuntimeException{

	private int code;

	/**
	 * 构造器
	 * @param code
	 */
	public BaituException(int code,String message) {
		super(message);
		this.code = code;
	}

	/**
	 * 构造器
	 */
	public BaituException() {
		super();
	}
	
}
