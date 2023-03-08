package com.hussain.exception;

import com.hussain.responses.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = MyAppException.class)
	@ResponseBody
	public Response<Object> handlePerfiosException(MyAppException ex) {
		return new Response<Object>(ex.getMessage(), ex.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public Response<Object> handlerException(Exception ex) {
		logger.error("Exception  Occured-:{}", ex);
		return new Response<Object>("Something went Wrong", HttpStatus.BAD_REQUEST);
	}

}