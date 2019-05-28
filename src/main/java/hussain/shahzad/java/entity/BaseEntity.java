package hussain.shahzad.java.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * 
 * @author shahzad.hussain
 *
 */
public class BaseEntity {
	public interface Columns {
		String ID = "id";
		String CREATED = "created_at";
		String UPDATED = "updated_at";
		String CREATOR = "created_by";
		String UPDATOR = "updated_by";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = Columns.ID, columnDefinition = "INT UNSIGNED", nullable = false)
	private Long id;
	@Column(name = Columns.CREATED, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = Columns.UPDATED, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;
	@Column(name = Columns.CREATOR, length = 80)
	@CreatedBy
	private String createdBy;
	@Column(name = Columns.UPDATOR, length = 80)
	@LastModifiedBy
	private String updatedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
