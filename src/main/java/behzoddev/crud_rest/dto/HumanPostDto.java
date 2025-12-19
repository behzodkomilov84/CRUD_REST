package behzoddev.crud_rest.dto;

import java.util.List;

public record HumanPostDto(String name, Integer age, List<CarPostDto> cars) {
}
