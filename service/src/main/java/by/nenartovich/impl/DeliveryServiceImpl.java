package by.nenartovich.impl;


import by.nenartovich.DeliveryService;
import by.nenartovich.dao.DeliveryRepository;
import by.nenartovich.dto.DeliveryDto;
import by.nenartovich.mappers.DeliveryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryServiceImpl(DeliveryRepository deliveryRepository, DeliveryMapper deliveryMapper) {
        this.deliveryRepository = deliveryRepository;
        this.deliveryMapper = deliveryMapper;
    }


    @Override
    public DeliveryDto findById(Long deliveryId) {
        return deliveryMapper.deliveryToDeliveryDto(deliveryRepository.getReferenceById(deliveryId));
    }

    @Override
    public List<DeliveryDto> findAllDeliveryDto() {
        return deliveryRepository.findAll().stream()
                .map(deliveryMapper::deliveryToDeliveryDto)
                .collect(Collectors.toList());
    }
}
