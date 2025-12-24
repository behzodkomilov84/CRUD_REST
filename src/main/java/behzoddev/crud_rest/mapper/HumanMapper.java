package behzoddev.crud_rest.mapper;

import behzoddev.crud_rest.dto.CarPostDto;
import behzoddev.crud_rest.dto.HumanPostDto;
import behzoddev.crud_rest.entity.Car;
import behzoddev.crud_rest.entity.Human;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface HumanMapper {

    @Mapping(target = "cars", ignore = true)
    default Human map(HumanPostDto humanPostDto) {
        Human human = mapHumanPostDtotoHuman(humanPostDto);

        for (CarPostDto carPostDto : humanPostDto.cars()) {
            Car car = mapCarPostDtoToCar(carPostDto);
            car.setHuman(human);
        }
        return human;
    }

    @Mapping(target = "id", ignore = true)
    Human mapHumanPostDtotoHuman(HumanPostDto humanPostDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "human", ignore = true)
    Car mapCarPostDtoToCar(CarPostDto carPostDto);
}
