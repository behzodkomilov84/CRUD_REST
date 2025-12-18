package behzoddev.crud_rest.dao;

import behzoddev.crud_rest.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface HumanRepository extends JpaRepository<Human, Long> {

    @Query("UPDATE Human h set h.age=:age where h.id=:id")
    @Modifying
    void updateHumanAge(Long id, Integer age);

}
