package by.nenartovich.dto;

import by.nenartovich.entity.Manager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    private  Long id;
    private  Date dateCreate;
    private  Date dateChange;
    private  boolean status;
    private List<ProductDto> products;
    private ManagerDto manager;
    private  Double price;
    private  ClientDto client;
    private  DeliveryDto delivery;
}
