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
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ManagerMapper managerMapper;
    private final OrderMapper orderMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, OrderRepository orderRepository, ClientRepository clientRepository, ManagerMapper managerMapper, OrderMapper orderMapper) {
        this.managerRepository = managerRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.managerMapper = managerMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public ManagerDto findByName(String managerName) {

        return managerMapper.managerToManagerDto(managerRepository.findByUserName(managerName));
    }

}
