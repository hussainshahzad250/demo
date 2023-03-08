package com.hussain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = Employee.Columns.TABLE)
public class Employee extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = BaseEntity.Columns.ID, columnDefinition = "INT UNSIGNED", nullable = false)
	private Long id;

    @Column(name = Columns.NAME)
    private String name;
    @Column(name = Columns.POPULATION)
    private int population;

    public interface Columns {
        String TABLE = "employees";
        String QUERY = "CREATE TABLE employees (id INT AUTO_INCREMENT,name  NOT NULL UNIQUE,population  NOT NULL UNIQUE,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
        String NAME = "name";
        String POPULATION = "population";
    }
}
