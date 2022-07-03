package by.nenartovich;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.dto.OrderDto;

import java.util.List;

public interface ManagerService {

    ManagerDto findById(Long managerId);

    List<ManagerDto> findAllManagerDto();

    void updateManager(ManagerDto managerDto);

    void createManager(Long managerId, String name);

    List<OrderDto> getManagerOrders(Long managerId);
}
