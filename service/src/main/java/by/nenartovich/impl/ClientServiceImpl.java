package by.nenartovich.impl;


import by.nenartovich.ClientService;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.entity.Client;
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

    @Override
    public void updateClient(ClientDto clientDto) {
        Client client = clientRepository.getReferenceById(clientDto.getId());
        clientRepository.save(clientMapper.updateClientFromClientDto(clientDto, client));
    }

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
