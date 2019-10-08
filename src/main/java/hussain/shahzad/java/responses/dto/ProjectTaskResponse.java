package hussain.shahzad.java.responses.dto;

import hussain.shahzad.java.pojos.ProjectTaskPojo;
/**
 * @author shahzad.hussain
 */


public class ProjectTaskResponse extends ProjectTaskPojo {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}