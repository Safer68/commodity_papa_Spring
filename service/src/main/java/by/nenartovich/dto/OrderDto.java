package by.nenartovich.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto implements Serializable {
    private final Long id;
    private final Date dateChange;
    private final boolean status;
    private final List<ProductDto> products;
    private final Double price;
    private final ClientDto client;
    private final DeliveryDto delivery;
}
