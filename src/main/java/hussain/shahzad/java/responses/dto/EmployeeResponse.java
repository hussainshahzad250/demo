package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.EmployeePojo;
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