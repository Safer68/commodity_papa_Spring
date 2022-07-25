package by.nenartovich.dto;

import by.nenartovich.StatusOrder;
import by.nenartovich.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements Serializable {
    private Long id;

    private Date dateCreate;

    private Date dateChange;

    @NotNull
    private List<ProductDto> products;

    private ManagerDto manager;

    private Double price;

    @NotNull
    @Valid
    private ClientDto client;

    private DeliveryDto delivery;

    private StatusOrder statusOrder;

    @NotNull
    @Valid
    private AddressDto addressDelivery;

    private String trackNumber;

    private String SmsSending;
}
