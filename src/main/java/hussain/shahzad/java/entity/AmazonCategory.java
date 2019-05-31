package hussain.shahzad.java.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author shahzad.hussain
 */

@Entity
@Table(name = AmazonCategory.Columns.TABLE)
public class AmazonCategory {

	public interface Columns {
		String TABLE = "amazon_categories";
		String NAME = "name";
		String URL = "url";
		String DESCRIPTION = "description";
		String SUBCATEGORIESCOUNT = "subcategoriesCount";
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

	@Column(name = Columns.NAME)
	private String name;
	@Column(name = Columns.URL)
	private String url;
	@Column(name = Columns.DESCRIPTION)
	private String description;

	@Column(name = Columns.SUBCATEGORIESCOUNT)
	private Integer subcategoriesCount;
//======================================================
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

//==================================================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSubcategoriesCount() {
		return subcategoriesCount;
	}

	public void setSubcategoriesCount(Integer subcategoriesCount) {
		this.subcategoriesCount = subcategoriesCount;
	}

}