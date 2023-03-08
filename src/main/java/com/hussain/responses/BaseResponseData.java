package com.hussain.responses;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
/**
 * 
 * @author shahzad
 *
 */
@JsonInclude(Include.NON_NULL)
public class BaseResponseData<T> {

	private List<T> data;
	
}
