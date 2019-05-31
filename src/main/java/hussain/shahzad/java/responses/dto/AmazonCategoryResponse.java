package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.AmazonCategoryPojo;
/**
 * @author shahzad.hussain
 */


public class AmazonCategoryResponse extends AmazonCategoryPojo {
	private Long amazonCategoryId;

	public Long  getAmazonCategoryId(){
		return amazonCategoryId;
	}
	public void setAmazonCategoryId( Long  amazonCategoryId){
		 this.amazonCategoryId= amazonCategoryId;
	}
}