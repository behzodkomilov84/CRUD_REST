package behzoddev.crud_rest.dao;

import behzoddev.crud_rest.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findCarsByHumanName(String name);
}
