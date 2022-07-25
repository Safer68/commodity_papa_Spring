package by.nenartovich.controller;


import by.nenartovich.*;
import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
@SessionAttributes({"person", "parameter", "filter", "basket"})
public class ClientController {
    private static final String FILTER = "filter";
    private static final String PERSON = "person";
    private static final String REDIRECT_CLIENT_CATALOG = "redirect:/client/catalog";
    private static final String ORDER = "order";
    private static final String DELIVERYS = "deliverys";
    private static final String BASKET = "basket";
    private static final String REDIRECT_CLIENT_ORDERS = "redirect:/client/orders";
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;

    @GetMapping
    public String getOrders(@ModelAttribute(FILTER) OrderFilter orderFilter,
                            @ModelAttribute(PERSON) ClientDto clientDto) {
        orderFilter.setClientName(clientDto.getName());
        return REDIRECT_CLIENT_CATALOG;
    }

    @GetMapping("/order/new")
    public String newOrder(@ModelAttribute(PERSON) ClientDto clientDto,
                           Model model) {
        OrderDto orderDto = new OrderDto();
        orderDto.setClient(clientDto);
        orderDto.setAddressDelivery(clientDto.getAddress());
        model.addAttribute(ORDER, orderDto);
        model.addAttribute(DELIVERYS, deliveryService.findAllDeliveryDto());
        return "/client/order-create";
    }

    @PostMapping("/orders")
    public String create(@ModelAttribute(ORDER) OrderDto orderDto,
                         @ModelAttribute(BASKET) Basket basket, Principal principal) {
        orderDto.setProducts(basket.getBasket());
        orderDto.setStatusOrder(StatusOrder.PENDING_PROCESSING);
        orderDto.setClient(clientService.findByName(principal.getName()));
        orderDto.setPrice(basket.getBasket().stream()
                .mapToDouble(ProductDto::getPrice)
                .sum());
        orderService.save(orderDto);
        basket.clear();
        return REDIRECT_CLIENT_ORDERS;
    }

    @PatchMapping("/update")
    public String updateClient(@ModelAttribute(PERSON) ClientDto clientDto) {
        clientService.updateClient(clientDto);
        return REDIRECT_CLIENT_ORDERS;
    }

    @ModelAttribute("person")
    public ClientDto populatePerson(Principal principal) {
        return clientService.findByName(principal.getName());
    }

    @ModelAttribute("parameter")
    public Parameter populateName() {
        return Parameter.builder().build();
    }

    @ModelAttribute("filter")
    public OrderFilter populateFilter() {
        return OrderFilter.builder().build();
    }

    @ModelAttribute("basket")
    public Basket populateBasket() {
        return Basket.builder().build();
    }
}