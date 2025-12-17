package behzoddev.springbootexample.dao;

import behzoddev.springbootexample.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {

}
