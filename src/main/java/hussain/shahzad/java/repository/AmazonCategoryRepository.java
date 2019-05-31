package hussain.shahzad.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hussain.shahzad.java.entity.AmazonCategory;
/**
 * @author shahzad.hussain
 */


@Repository
public interface AmazonCategoryRepository extends JpaRepository<AmazonCategory, Long> {

}
