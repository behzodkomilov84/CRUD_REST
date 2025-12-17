package behzoddev.crud_rest.dao;

import behzoddev.crud_rest.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HumanRepository extends JpaRepository<Human, Long> {


}
