package by.nenartovich.impl;


import by.nenartovich.ClientService;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.mappers.ClientMapper;
import by.nenartovich.mappers.OrderMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final OrderMapper orderMapper;

   /* @Override
    public ClientDto findById(Long clientId) {
        return clientMapper.clientToClientDto(clientRepository.getReferenceById(clientId));
    }

    @Override
    public List<ClientDto> findAllClientDto() {
        return clientRepository.findAll().stream()
                .map(clientMapper::clientToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        clientRepository.save(clientMapper.clientDtoToClient(clientDto));
    }

    @Override
    public List<OrderDto> getClientOrders(Long clientId) {
        return clientRepository.getClientOrders(clientId).stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }*/

    @Override
    public ClientDto findByName(String clientName) {
        return clientMapper.clientToClientDto(clientRepository.findByUserName(clientName));
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientMapper
                .clientToClientDto(clientRepository.save(clientMapper.clientDtoToClient(clientDto)));
    }
}
