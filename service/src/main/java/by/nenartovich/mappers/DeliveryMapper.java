package by.nenartovich.mappers;

import by.nenartovich.dto.DeliveryDto;
import by.nenartovich.entity.Delivery;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DeliveryMapper {
    Delivery deliveryDtoToDelivery(DeliveryDto deliveryDto);

    DeliveryDto deliveryToDeliveryDto(Delivery delivery);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Delivery updateDeliveryFromDeliveryDto(DeliveryDto deliveryDto, @MappingTarget Delivery delivery);
}
