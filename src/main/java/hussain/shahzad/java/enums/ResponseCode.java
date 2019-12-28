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
package hussain.shahzad.java.enums;

/**
 * @author shahzad.hussain
 *
 */
public enum ResponseCode {

	SUCCESS("Your feedback submitted successfully", "SUCCESS"),

	INTERNAL_SERVER_ERROR("Internal server error", "501"),

	/* Employees */
	EMPTY_EMPLOYEE_ID("employeeId cannot be empty!", "EMP_EMPLOYEE_ID"),
	EMPTY_FIRSTNAME("firstName cannot be empty!", "EMP_FIRSTNAME"),
	EXIST_FIRSTNAME("firstName already exist!", "EXS_FIRSTNAME"),
	EMPTY_LASTNAME("lastName cannot be empty!", "EMP_LASTNAME"),
	EXIST_LASTNAME("lastName already exist!", "EXS_LASTNAME"), EMPTY_SALARY("salary cannot be empty!", "EMP_SALARY"),
	EXIST_SALARY("salary already exist!", "EXS_SALARY"), EMPLOYEE_NOT_FOUND("Employee not found!", "NF_EMPLOYEE"),
	NO_EMPLOYEES_FOUND("No Employees added yet!", "NO_EMPLOYEE_ADDED"),

	/* Users */
	EMPTY_USER_ID("userId cannot be empty!", "EMP_USER_ID"), USER_NOT_FOUND("User not found!", "NF_USER"),
	NO_USERS_FOUND("No Users added yet!", "NO_USER_ADDED"),

	/* Enquirys */
	EMPTY_ENQUIRY_ID("enquiryId cannot be empty!", "EMP_ENQUIRY_ID"),
	ENQUIRY_NOT_FOUND("Enquiry not found!", "NF_ENQUIRY"),
	NO_ENQUIRYS_FOUND("No Enquirys added yet!", "NO_ENQUIRY_ADDED"),

	/* Addresss */
	EMPTY_ADDRESS_ID("addressId cannot be empty!", "EMP_ADDRESS_ID"),
	ADDRESS_NOT_FOUND("Address not found!", "NF_ADDRESS"),
	NO_ADDRESSS_FOUND("No Addresss added yet!", "NO_ADDRESS_ADDED"),

	/* Orders */
	EMPTY_ORDER_ID("orderId cannot be empty!", "EMP_ORDER_ID"), ORDER_NOT_FOUND("Order not found!", "NF_ORDER"),
	NO_ORDERS_FOUND("No Orders added yet!", "NO_ORDER_ADDED"),

	/* Tests */
	EMPTY_TEST_ID("testId cannot be empty!", "EMP_TEST_ID"), TEST_NOT_FOUND("Test not found!", "NF_TEST"),
	NO_TESTS_FOUND("No Tests added yet!", "NO_TEST_ADDED"),
	INVALID_ARGUEMENTS_PASSED("Please check your request!", "INV_ARGS"), COMMON("", ""),
	PERSON_NOT_FOUND("Person Not found", "NOT_FOUND");

	private String message;
	private String code;

	ResponseCode(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

}
