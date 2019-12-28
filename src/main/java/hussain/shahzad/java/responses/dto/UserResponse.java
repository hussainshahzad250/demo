package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.UserPojo;
/**
 * @author shahzad.hussain
 */


public class UserResponse extends UserPojo {

	private Long userId;

	public Long  getUserId(){
		return userId;
	}
	public void setUserId( Long  userId){
		 this.userId= userId;
	}
}