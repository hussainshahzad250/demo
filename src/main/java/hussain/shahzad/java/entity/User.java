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
@Table(name = User.Columns.TABLE)
public class User {
	public interface Columns {
		String TABLE = "users";
		String QUERY = "CREATE TABLE users (id INT AUTO_INCREMENT not null,firstName varchar(55) default null ,lastName varchar(55) default null ,email varchar(55) default null,mobile varchar(55) default null,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
		String FIRSTNAME = "firstName";
		String LASTNAME = "lastName";
		String EMAIL = "email";
		String MOBILE = "mobile";
		String ID = "id";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = Columns.ID, columnDefinition = "INT UNSIGNED", nullable = false)
	private Long id;

	@Column(name = Columns.FIRSTNAME)
	private String firstName;
	@Column(name = Columns.LASTNAME)
	private String lastName;
	@Column(name = Columns.EMAIL)
	private String email;
	@Column(name = Columns.MOBILE)
	private String mobile;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}