package hussain.shahzad.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author shahzad.hussain
 */


@Entity
@Table(name=ProjectTask.Columns.TABLE)
public class ProjectTask extends BaseEntity{
	public interface Columns{
		String TABLE="projectTasks";
		String QUERY="CREATE TABLE projectTasks (id INT AUTO_INCREMENT,summary ,acceptanceCriteria ,status ,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
		String SUMMARY ="summary";
		String ACCEPTANCECRITERIA ="acceptanceCriteria";
		String STATUS ="status";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT UNSIGNED", nullable = false)
	private Long id;

	@Column(name = Columns.SUMMARY, columnDefinition="")
	private String summary;
	@Column(name = Columns.ACCEPTANCECRITERIA, columnDefinition="")
	private String acceptanceCriteria;
	@Column(name = Columns.STATUS, columnDefinition="")
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