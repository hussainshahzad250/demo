/*************************************************************************
* 
* SATIN CREDITCARE NETWORK LIMITED CONFIDENTIAL
* __________________
* 
*  [2018] SATIN CREDITCARE NETWORK LIMITED
*  All Rights Reserved.
* 
* NOTICE:  All information contained herein is, and remains the property of SATIN CREDITCARE NETWORK LIMITED, and
* The intellectual and technical concepts contained herein are proprietary to SATIN CREDITCARE NETWORK LIMITED
* and may be covered by India and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
* Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission
* is obtained from SATIN CREDITCARE NETWORK LIMITED.
*/
/**
 * 
 */
package com.hussain.responses;

import org.springframework.http.HttpStatus;

/**
 * @author shahzad.hussain
 *
 */
public class Response<T> {

	public HttpStatus status;
	public Integer code;
	public String message;
	public T response;

	public Response() {

	}

	public Response(String message, HttpStatus httpStatus) {
		this.message = message;
		this.status = httpStatus;
		this.code = httpStatus.value();
	}

	public Response(String message,  T response,HttpStatus httpStatus) {
		this.message = message;
		this.status = httpStatus;
		this.code = httpStatus.value();
		this.response = response;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

}
