package by.nenartovich;


import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.ManagerDto;

public interface ClientService {
    ClientDto findByName(String clientName);
    /*ClientDto findById(Long clientId);

    List<ClientDto> findAllClientDto();

    void updateClient(ClientDto clientDto);

    List<OrderDto> getClientOrders(Long clientId);*/

    ClientDto save(ClientDto clientDto);
}
