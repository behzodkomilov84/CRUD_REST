// Bu klassni o'rniga HumanRepository interface yaratildi.

/*
package behzoddev.springbootexample.dao;

import behzoddev.springbootexample.entity.Car;
import behzoddev.springbootexample.entity.Human;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HumanDao {

//    @PersistenceContext
    private final EntityManagerFactory entityManagerFactory;

    public void go(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Human human = entityManager.find(Human.class, 1);
        entityManager.getTransaction().commit();
        System.out.println("Yangi Human Bu yerda: " + human);
    }
}
*/
