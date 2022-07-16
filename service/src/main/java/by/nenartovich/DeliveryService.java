package by.nenartovich;

import by.nenartovich.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    DeliveryDto findById(Long deliveryId);

    List<DeliveryDto> findAllDeliveryDto();
    /*ManagerDto findByName(String managerName);

    List<ManagerDto> findAllManagerDto();

    void updateManager(ManagerDto managerDto);

    void createManager(Long managerId, String name);

    List<OrderDto> getManagerOrders(Long managerId);
    List<OrderDto> getManagerOrders (String managerName);*/
}
