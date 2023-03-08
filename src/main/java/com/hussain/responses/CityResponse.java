package com.hussain.responses;

import com.hussain.pojos.CityPojo;
/**
 * @author shahzad.hussain
 */


public class CityResponse extends CityPojo {
	private Long cityId;

	public Long  getCityId(){
		return cityId;
	}
	public void setCityId( Long  cityId){
		 this.cityId= cityId;
	}
}