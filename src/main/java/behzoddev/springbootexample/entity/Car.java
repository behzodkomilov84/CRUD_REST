package behzoddev.springbootexample.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cars")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private Long year;

    @ManyToOne(fetch = FetchType.LAZY)
    private Human human;
}

