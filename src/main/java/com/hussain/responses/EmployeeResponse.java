package com.hussain.responses;

import com.hussain.pojos.EmployeePojo;
/**
 * @author shahzad.hussain
 */


public class EmployeeResponse extends EmployeePojo {
	private Long employeeId;

	public Long  getEmployeeId(){
		return employeeId;
	}
	public void setEmployeeId( Long  employeeId){
		 this.employeeId= employeeId;
	}
}