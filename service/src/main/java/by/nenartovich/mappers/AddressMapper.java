package by.nenartovich.mappers;

import by.nenartovich.dto.AddressDto;
import by.nenartovich.entity.Address;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AddressMapper {
    Address addressDtoToAddress(AddressDto addressDto);

    AddressDto addressToAddressDto(Address address);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Address updateAddressFromAddressDto(AddressDto addressDto, @MappingTarget Address address);
}
