package hussain.shahzad.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hussain.shahzad.java.entity.User;
/**
 * @author shahzad.hussain
 */


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
