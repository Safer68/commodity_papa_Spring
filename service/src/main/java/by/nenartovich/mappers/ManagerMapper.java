package by.nenartovich.mappers;

import by.nenartovich.dto.ManagerDto;
import by.nenartovich.entity.Manager;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ManagerMapper {

   /* @Mappings({*/
            @Mapping(ignore = true, target = "password")
           /* @Mapping(ignore = true, target = "userName"),
            @Mapping(ignore = true, target = "active")
    })*/
    Manager managerDtoToManager(ManagerDto managerDto);
    ManagerDto managerToManagerDto(Manager manager);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Manager updateManagerFromManagerDto(ManagerDto managerDto, @MappingTarget Manager manager);
}
