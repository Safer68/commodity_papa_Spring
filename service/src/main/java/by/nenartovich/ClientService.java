package by.nenartovich;


import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.ManagerDto;

public interface ClientService {
    ClientDto findByName(String clientName);
    /*ClientDto findById(Long clientId);

    List<ClientDto> findAllClientDto();

    List<OrderDto> getClientOrders(Long clientId);*/

    void updateClient(ClientDto clientDto);
    ClientDto save(ClientDto clientDto);
}
