package behzoddev.crud_rest.controller;

import behzoddev.crud_rest.dao.UserEntityRepository;
import behzoddev.crud_rest.entity.Role;
import behzoddev.crud_rest.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class UserController {

    private final UserEntityRepository entityRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody RegCredential regCredential) {
        UserEntity user = UserEntity.builder()
                .username(regCredential.getUsername())
                .password(passwordEncoder.encode(regCredential.getPassword()))
                .build();

        Role role = Role.builder()
                .roleName("ROLE_USER")
                .userEntity(user)
                .build();

        user.setRoles(List.of(role));

        entityRepository.save(user);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class RegCredential {
        private String username;
        private String password;
    }
}
