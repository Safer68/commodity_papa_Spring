package by.nenartovich;

import by.nenartovich.dto.ManagerDto;

public interface ManagerService {

    /*ManagerDto findById(Long managerId);*/
    ManagerDto findByName(String managerName);

    /*List<ManagerDto> findAllManagerDto();*/

    /*void updateManager(ManagerDto managerDto);*/

    /* void createManager(Long managerId, String name);*/

    /* List<OrderDto> getManagerOrders(Long managerId);*/
    /* List<OrderDto> getManagerOrders (String managerName);*/
    /*Page<OrderDto> findPaginated(Pageable pageable, Long managerId);*/
    /*Page<OrderDto> findAllPaginated(int pageNumber, String sortField, String sortDirection, Long managerId);*/

}
