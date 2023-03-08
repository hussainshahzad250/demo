package com.hussain.responses;

import com.hussain.pojos.AmazonCategoryPojo;
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