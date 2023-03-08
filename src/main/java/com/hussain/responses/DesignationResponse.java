package com.hussain.responses;

import com.hussain.pojos.DesignationPojo;
/**
 * @author shahzad.hussain
 */


public class DesignationResponse extends DesignationPojo {
	private Long designationId;

	public Long  getDesignationId(){
		return designationId;
	}
	public void setDesignationId( Long  designationId){
		 this.designationId= designationId;
	}
}