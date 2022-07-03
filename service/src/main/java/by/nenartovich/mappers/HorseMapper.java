package by.nenartovich.mappers;


import by.nenartovich.dto.HorseDto;
import by.nenartovich.entity.Horse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HorseMapper {
    HorseDto toHorseDto(Horse horse);

    Horse toHorse(HorseDto horseDto);
}
