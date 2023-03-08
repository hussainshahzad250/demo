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
@Table(name = City.Columns.TABLE)
public class City {
	public interface Columns {
		String TABLE = "citys";
		String QUERY = "CREATE TABLE citys (id INT AUTO_INCREMENT,name  NOT NULL UNIQUE,population  NOT NULL UNIQUE,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
		String NAME = "name";
		String POPULATION = "population";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "INT UNSIGNED", nullable = false)
	private Long id;

	@Column(name = Columns.NAME)
	private String name;
	@Column(name = Columns.POPULATION)
	private int population;

}