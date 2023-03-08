package com.hussain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shahzad.hussain
 */

@Getter
@Setter
@Entity
@Table(name = Designation.Columns.TABLE)
public class Designation {
	public interface Columns {
		String TABLE = "designations";
		String QUERY = "CREATE TABLE designations (id INT AUTO_INCREMENT,firstName  NOT NULL UNIQUE,lastName  NOT NULL UNIQUE,salary  NOT NULL UNIQUE,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
		String FIRSTNAME = "firstName";
		String LASTNAME = "lastName";
		String SALARY = "salary";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT UNSIGNED", nullable = false)
	private Long id;

	@Column(name = Columns.FIRSTNAME)
	private String firstName;
	@Column(name = Columns.LASTNAME)
	private String lastName;
	@Column(name = Columns.SALARY)
	private Double salary;

}