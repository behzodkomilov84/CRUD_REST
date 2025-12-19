package behzoddev.crud_rest.dao;

import behzoddev.crud_rest.entity.Human;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface HumanRepository extends JpaRepository<Human, Long> {

    @EntityGraph(value = "humanWithCars")
    @Query("select h from Human h")
    List<Human> findAllWithCars();

    @EntityGraph("humanWithCars")
    Optional<Human> findById(Long id);


    @Query("UPDATE Human h set h.age=:age where h.id=:id")
    @Modifying
    void updateHumanAge(Long id, Integer age);

}
