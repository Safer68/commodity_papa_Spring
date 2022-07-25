package by.nenartovich;

import by.nenartovich.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {

    DeliveryDto findById(Long deliveryId);

    List<DeliveryDto> findAllDeliveryDto();
}
