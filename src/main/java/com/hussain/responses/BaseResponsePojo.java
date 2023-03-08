package com.hussain.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.hussain.enums.LoanApplicationResponseCode;

/**
 * 
 * @author shahzad
 *
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponsePojo {

	private String status;
	private String msg;

	public BaseResponsePojo(LoanApplicationResponseCode roEmiResponseCode) {
		this(roEmiResponseCode.getMessage());
	}

	public BaseResponsePojo(String msg) {
		this.msg = msg;
	}
}
