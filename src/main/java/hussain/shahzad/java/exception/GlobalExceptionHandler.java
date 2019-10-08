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

package hussain.shahzad.java.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import hussain.shahzad.java.responses.dto.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = MyAppException.class)
	@ResponseBody
	public Response<Object> handlePerfiosException(MyAppException ex) {
		return new Response<>(ex.getMessage(), ex.getHttpStatus());
	}

	@ExceptionHandler(Exception.class)
	public Response<Object> handlerException(Exception ex) {
		logger.error("Exception  Occured-:{}", ex);
		return new Response<>("Something went Wrong", HttpStatus.BAD_REQUEST);
	}

}