package behzoddev.crud_rest.service;

import behzoddev.crud_rest.dao.HumanRepository;
import behzoddev.crud_rest.entity.Human;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;

    @Transactional
    public void saveHumanWithLog(Human human) {
        humanRepository.save(human);
    }
}
