package behzoddev.crud_rest.service;

import behzoddev.crud_rest.dao.HumanRepository;
import behzoddev.crud_rest.dto.HumanPostDto;
import behzoddev.crud_rest.entity.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;

    public List<Human> getHumans() {
        return humanRepository.findAll();
    }

    public Optional<Human> getHuman(Long id) {
        Optional<Human> humanById = humanRepository.findById(id);
        return humanById;
    }

    @Transactional
    public Human saveHuman(HumanPostDto humanPostDto) {
        Human human = Human.builder().name(humanPostDto.name()).age(humanPostDto.age()).build();
        return humanRepository.save(human);
    }

    @Transactional
    public Human saveHuman(Human human) {
        return humanRepository.save(human);
    }

    @Transactional
    public void remove(Long id) {
        humanRepository.deleteById(id);
    }

    @Transactional
    public void updateHumanAge(Long id, Integer age) {
        humanRepository.updateHumanAge(id, age);
    }
}
