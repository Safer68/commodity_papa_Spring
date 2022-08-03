package by.nenartovich.impl;


import by.nenartovich.ManagerService;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dao.ManagerRepository;
import by.nenartovich.dao.OrderRepository;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.mappers.ManagerMapper;
import by.nenartovich.mappers.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
    }

    @Override
    public ManagerDto findByName(String managerName) {

        return managerMapper.managerToManagerDto(managerRepository.findByUserName(managerName));
    }

}
