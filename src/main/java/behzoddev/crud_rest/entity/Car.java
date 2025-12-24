package behzoddev.crud_rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "cars")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    @ToString
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private Long year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Human human;
}

