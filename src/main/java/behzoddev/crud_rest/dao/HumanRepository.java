package behzoddev.crud_rest.dao;

import behzoddev.crud_rest.entity.Human;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HumanRepository extends JpaRepository<Human, Long> {


}
