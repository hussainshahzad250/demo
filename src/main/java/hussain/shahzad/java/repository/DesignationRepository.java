package hussain.shahzad.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hussain.shahzad.java.entity.Designation;
/**
 * @author shahzad.hussain
 */


@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long> {

}
