package by.nenartovich.mappers;

import by.nenartovich.dto.RoleDto;
import by.nenartovich.entity.Role;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleMapper {
    Role roleDtoToRole(RoleDto roleDto);

    RoleDto roleToRoleDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role updateRoleFromRoleDto(RoleDto roleDto, @MappingTarget Role role);
}
