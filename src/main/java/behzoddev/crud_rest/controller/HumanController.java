package behzoddev.crud_rest.controller;

import behzoddev.crud_rest.entity.Human;
import behzoddev.crud_rest.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HumanController {

    private final HumanService humanService;

    @RequestMapping
    public List<Human> getHumans(){
        return humanService.getHumans();
    }
}
