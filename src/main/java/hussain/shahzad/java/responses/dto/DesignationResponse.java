package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.DesignationPojo;
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