package behzoddev.crud_rest.controller;

import behzoddev.crud_rest.dto.HumanPostDto;
import behzoddev.crud_rest.entity.Human;
import behzoddev.crud_rest.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/human")
public class HumanController {

    private final HumanService humanService;

    @GetMapping
    public ResponseEntity<List<Human>> getHumans(){
        return ResponseEntity.ok(humanService.getHumans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Human> getHuman(@PathVariable Long id){
            Human human = humanService.getHuman(id).orElseThrow();
            return ResponseEntity.ok(human);
    }

    @PostMapping
    public ResponseEntity<Void> createHuman(@RequestBody HumanPostDto humanPostDto){
        Human human = humanService.saveHuman(humanPostDto);
        return ResponseEntity.created(URI.create("human/" + human.getId())).build();
    }

    @PutMapping
    public ResponseEntity<Human> updateHuman(@RequestBody Human human){
        if (human.getId() == null){
        humanService.saveHuman(human);
        return ResponseEntity.created(URI.create("human/" + human.getId())).body(human);
        }else {
        humanService.saveHuman(human);
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHuman(@PathVariable Long id){
       humanService.remove(id);
       return ResponseEntity.noContent().build();
    }

}
