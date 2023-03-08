package com.hussain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author shahzad.hussain
 */

@Getter
@Setter
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

}