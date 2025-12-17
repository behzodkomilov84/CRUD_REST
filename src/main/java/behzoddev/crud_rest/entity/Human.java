package behzoddev.crud_rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "humans")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@NamedEntityGraph(
        name = "humanWithCars",
        attributeNodes = {
                @NamedAttributeNode("cars")
        }
)
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "human")
    private List<Car> cars;
}
