package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.CityPojo;
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