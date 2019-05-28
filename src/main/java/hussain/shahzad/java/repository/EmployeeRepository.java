package hussain.shahzad.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hussain.shahzad.java.entity.Employee;
/**
 * @author shahzad.hussain
 */


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
