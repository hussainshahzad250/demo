package com.hussain.enums;

/**
 * @author shahzad.hussain
 *
 */
public enum LoanApplicationResponseCode {

	SUCCESS("Success", "SUCCESS"),

	INTERNAL_SERVER_ERROR("Internal server error", "501"),

	/* Employees*/
	EMPTY_EMPLOYEE_ID("employeeId cannot be empty!","EMP_EMPLOYEE_ID"),
	EMPTY_FIRSTNAME("firstName cannot be empty!","EMP_FIRSTNAME"),
	EXIST_FIRSTNAME("firstName already exist!","EXS_FIRSTNAME"),
	EMPTY_LASTNAME("lastName cannot be empty!","EMP_LASTNAME"),
	EXIST_LASTNAME("lastName already exist!","EXS_LASTNAME"),
	EMPTY_SALARY("salary cannot be empty!","EMP_SALARY"),
	EXIST_SALARY("salary already exist!","EXS_SALARY"),
	EMPLOYEE_NOT_FOUND("Employee not found!","NF_EMPLOYEE"),
	NO_EMPLOYEES_FOUND("No Employees added yet!","NO_EMPLOYEE_ADDED"),
	INVALID_ARGUEMENTS_PASSED("Please check your request!", "INV_ARGS"), COMMON("", ""), PERSON_NOT_FOUND("Person Not found","NOT_FOUND");

	private String message;
	private String code;

	LoanApplicationResponseCode(String message, String code) {
		this.message = message;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
