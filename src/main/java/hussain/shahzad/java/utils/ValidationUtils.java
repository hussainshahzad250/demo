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
package hussain.shahzad.java.utils;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import hussain.shahzad.java.constants.Constants;
import hussain.shahzad.java.exception.MyAppException;
import hussain.shahzad.java.requests.dto.UserRequest;


public class ValidationUtils extends Constants {

	public static void validateRequest(UserRequest request) {

		if (StringUtils.isEmpty(request.getFirstName())) {
			throw new MyAppException(FIRST_NAME_EMPTY, HttpStatus.BAD_REQUEST);
		}

		if (StringUtils.isEmpty(request.getLastName())) {
			throw new MyAppException(LAST_NAME_EMPTY, HttpStatus.BAD_REQUEST);
		}

		if (StringUtils.isEmpty(request.getEmail())) {
			throw new MyAppException(EMAIL_EMPTY, HttpStatus.BAD_REQUEST);
		}

		if (StringUtils.isEmpty(request.getMobile())) {
			throw new MyAppException(MOBILE_EMPTY, HttpStatus.BAD_REQUEST);
		}

	}

}
