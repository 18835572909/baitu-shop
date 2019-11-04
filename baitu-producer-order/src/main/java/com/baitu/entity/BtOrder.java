package com.baitu.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * @author renhuibo  2019-11-01 01:26:16
 * @Description
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class BtOrder {
	private String orderCode;
	private Date orderTime;
}
