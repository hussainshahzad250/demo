package hussain.shahzad.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * @author shahzad.hussain
 */


@Entity
@Table(name=Employee.Columns.TABLE)
public class Employee extends BaseEntity{
	public interface Columns{
		String TABLE="employees";
		String QUERY="CREATE TABLE employees (id INT AUTO_INCREMENT,name  NOT NULL UNIQUE,population  NOT NULL UNIQUE,created DATETIME,updated DATETIME,creator INTEGER,updator INTEGER,PRIMARY KEY (id));";
		String NAME ="name";
		String POPULATION ="population";
	}

	@Column(name = Columns.NAME, columnDefinition=" NOT NULL UNIQUE")
	private String name;
	@Column(name = Columns.POPULATION, columnDefinition=" NOT NULL UNIQUE")
	private int population;

	public String getName(){
		return name;
	}
	public void setName(String name){
		 this.name= name;
	}
	public int getPopulation(){
		return population;
	}
	public void setPopulation(int population){
		 this.population= population;
	}
}