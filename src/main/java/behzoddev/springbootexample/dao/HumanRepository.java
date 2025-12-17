package behzoddev.springbootexample.dao;

import behzoddev.springbootexample.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface HumanRepository extends JpaRepository<Human, Long> {

    List<Human> findAllByAgeEquals(Integer age);

    List<Human> findHumansByCarsEmptyAndAgeBetweenAndNameEquals(Integer startAge, Integer endAge, String name);

    @Query("from Human h left join Car c on h.id = c.human.id where c.model = :model")
    List<Human> findHumanWithModel(String model);


    @Query(value = "select h.id, h.name, h.age from humans h left join test.cars c on h.id = c.human_id where c.id is null", nativeQuery = true)
    List<Human> findHumanWithoutCar();

    @Modifying
    @Query("update Human h set h.name = :name")
    void update(String name);
}
