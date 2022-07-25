package by.nenartovich;


import by.nenartovich.dto.ClientDto;

public interface ClientService {
    ClientDto findByName(String clientName);

    void updateClient(ClientDto clientDto);

    ClientDto save(ClientDto clientDto);
}
