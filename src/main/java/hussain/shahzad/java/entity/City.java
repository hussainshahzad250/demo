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

	@Column(name = Columns.NAME, columnDefinition = " NOT NULL UNIQUE")
	private String name;
	@Column(name = Columns.POPULATION, columnDefinition = " NOT NULL UNIQUE")
	private int population;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}