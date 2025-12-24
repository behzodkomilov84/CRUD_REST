package behzoddev.crud_rest.controller;

import behzoddev.crud_rest.dto.HumanPostDto;
import behzoddev.crud_rest.entity.Human;
import behzoddev.crud_rest.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/humans")
public class HumanController {

    private final HumanService humanService;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") //Mappinglarni oldiga qo'yib chiqiladi
    public ResponseEntity<List<Human>> getHumans() {
        List<Human> humans = humanService.getHumans();
        return ResponseEntity.ok(humans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Human> getHuman(@PathVariable Long id) {
        Human human = humanService.getHuman(id).orElseThrow();
        return ResponseEntity.ok(human);
    }

    @PostMapping
    public ResponseEntity<Void> createHuman(@RequestBody HumanPostDto humanPostDto) {
        Human human = humanService.saveHuman(humanPostDto);
        return ResponseEntity.created(URI.create("human/" + human.getId())).build();
    }

    @PutMapping
    public ResponseEntity<Human> updateHuman(@RequestBody Human human) {
        if (human.getId() == null) {
            humanService.saveHuman(human);
            return ResponseEntity.created(URI.create("human/" + human.getId())).body(human);
        } else {
            humanService.saveHuman(human);
            return ResponseEntity.noContent().build();
        }
    }

    @PatchMapping
    public ResponseEntity<Void> updateHumanAge(@RequestParam Long id, @RequestParam Integer age) {
        humanService.updateHumanAge(id, age);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHuman(@PathVariable Long id) {

        //Faqat ADMIN o'chira olishi uchun quyidagi kod qilinadi.

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities =
                authentication.getAuthorities();

        boolean match = authorities.stream()
                .anyMatch(grantedAuthority ->
                        grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_ADMIN"));

        if (!match) {
            throw new AccessDeniedException("only with role ROLE_ADMIN");
        }
        //-------------------------------------------------------

        humanService.remove(id);
        return ResponseEntity.noContent().build();
    }

}
