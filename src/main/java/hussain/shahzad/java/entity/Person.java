package hussain.shahzad.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import hussain.shahzad.java.entity.BaseEntity.Columns;

@Entity
@Table(name = Person.Columns.TABLE)
public class Person {
	public interface Columns {
		String TABLE = "persons";
		String QUERY = "CREATE TABLE persons (id INT AUTO_INCREMENT,firstName  NOT NULL UNIQUE,lastName  NOT NULL UNIQUE,salary  NOT NULL UNIQUE,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}