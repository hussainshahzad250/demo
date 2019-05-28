package hussain.shahzad.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import hussain.shahzad.java.entity.BaseEntity.Columns;

/**
 * @author shahzad.hussain
 */

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

	@Column(name = Columns.FIRSTNAME, columnDefinition = " NOT NULL UNIQUE")
	private String firstName;
	@Column(name = Columns.LASTNAME, columnDefinition = " NOT NULL UNIQUE")
	private String lastName;
	@Column(name = Columns.SALARY, columnDefinition = " NOT NULL UNIQUE")
	private Double salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
}