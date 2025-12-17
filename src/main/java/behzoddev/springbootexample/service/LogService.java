package behzoddev.springbootexample.service;

import behzoddev.springbootexample.dao.LogRepository;
import behzoddev.springbootexample.entity.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    @Transactional
    public void saveLog(Log log) {
        logRepository.save(log);
        if (1==1){
            throw new RuntimeException("test");
        }
    }
}
