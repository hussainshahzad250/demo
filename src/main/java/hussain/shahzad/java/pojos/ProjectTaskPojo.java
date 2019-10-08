package hussain.shahzad.java.pojos;

/**
 * @author shahzad.hussain
 */


public class ProjectTaskPojo {
	private String summary;
	private String acceptanceCriteria;
	private String status;

	public String getSummary(){
		return summary;
	}
	public void setSummary(String summary){
		 this.summary= summary;
	}
	public String getAcceptanceCriteria(){
		return acceptanceCriteria;
	}
	public void setAcceptanceCriteria(String acceptanceCriteria){
		 this.acceptanceCriteria= acceptanceCriteria;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status){
		 this.status= status;
	}
}