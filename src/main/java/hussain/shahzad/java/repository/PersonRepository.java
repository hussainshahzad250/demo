package hussain.shahzad.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hussain.shahzad.java.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
