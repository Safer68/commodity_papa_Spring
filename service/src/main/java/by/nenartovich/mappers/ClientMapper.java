package by.nenartovich.mappers;

import by.nenartovich.dto.ClientDto;
import by.nenartovich.entity.Client;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {
    Client clientDtoToClient(ClientDto clientDto);

    ClientDto clientToClientDto(Client client);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client updateClientFromClientDto(ClientDto clientDto, @MappingTarget Client client);
}
