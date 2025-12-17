package behzoddev.crud_rest.service;

import behzoddev.crud_rest.dao.HumanRepository;
import behzoddev.crud_rest.entity.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;

    public List<Human> getHumans(){
        return humanRepository.findAll();
    }
}
