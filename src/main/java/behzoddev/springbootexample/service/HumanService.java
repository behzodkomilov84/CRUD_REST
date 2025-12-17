package behzoddev.springbootexample.service;

import behzoddev.springbootexample.dao.HumanRepository;
import behzoddev.springbootexample.dao.LogRepository;
import behzoddev.springbootexample.entity.Human;
import behzoddev.springbootexample.entity.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;
    private final LogRepository logRepository;


    @Transactional(readOnly = true)
    public void soutAllHumansCars() {
        List<Human> humans = humanRepository.findAll();
        for (Human human : humans) {
            System.out.println(human.getCars());
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveHumanWithLog(Human human) {
        humanRepository.save(human);
        if (1 == 2) {
            throw new RuntimeException();
        }
        logRepository.save(Log.builder().payload("Human with id: " + human.getId() + " был сохранен...").build());
    }
}
