package com.hussain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
public class BaseEntity {
	public interface Columns {
		String ID = "id";
		String CREATED = "created_at";
		String UPDATED = "updated_at";
		String CREATOR = "created_by";
		String UPDATER = "updated_by";
	}


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
	@Column(name = Columns.UPDATER, length = 80)
	@LastModifiedBy
	private String updatedBy;

}
