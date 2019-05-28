package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.PersonPojo;
public class PersonResponse extends PersonPojo {
	private Long personId;

	public Long  getPersonId(){
		return personId;
	}
	public void setPersonId( Long  personId){
		 this.personId= personId;
	}
}