package hussain.shahzad.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hussain.shahzad.java.entity.City;
/**
 * @author shahzad.hussain
 */


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

}
