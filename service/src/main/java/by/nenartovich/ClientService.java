package by.nenartovich;


import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.OrderDto;

import java.util.List;

public interface ClientService {
    ClientDto findById(Long clientId);

    List<ClientDto> findAllClientDto();

    void updateClient(ClientDto clientDto);

    List<OrderDto> getClientOrders(Long clientId);
    ClientDto save(ClientDto clientDto);
}
