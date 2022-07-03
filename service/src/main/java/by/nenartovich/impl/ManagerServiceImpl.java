package by.nenartovich.impl;


import by.nenartovich.ManagerService;
import by.nenartovich.dao.ManagerRepository;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.mappers.ManagerMapper;
import by.nenartovich.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerMapper managerMapper;
    private final OrderMapper orderMapper;

    public ManagerServiceImpl(ManagerRepository managerRepository, ManagerMapper managerMapper, OrderMapper orderMapper) {
        this.managerRepository = managerRepository;
        this.managerMapper = managerMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public ManagerDto findById(Long managerId) {
        return managerMapper.managerToManagerDto(managerRepository.getReferenceById(managerId));
    }

    @Override
    public List<ManagerDto> findAllManagerDto() {
        return managerRepository.findAll().stream()
                .map(managerMapper::managerToManagerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getManagerOrders(Long managerId) {
        return managerRepository.getManagerOrders(managerId).stream()
                .map(orderMapper::orderToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public void updateManager(ManagerDto managerDto) {
        managerRepository.save(managerMapper.managerDtoToManager(managerDto));
    }

    @Override
    public void createManager(Long managerId, String name) {

    }
}
