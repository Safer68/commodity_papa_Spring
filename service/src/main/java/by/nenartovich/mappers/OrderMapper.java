package by.nenartovich.mappers;

import by.nenartovich.dto.OrderDto;
import by.nenartovich.entity.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {
    Order orderDtoToOrder(OrderDto orderDto);

    @Mapping(ignore = true, target = "price")
    OrderDto orderToOrderDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order updateOrderFromOrderDto(OrderDto orderDto, @MappingTarget Order order);
}
