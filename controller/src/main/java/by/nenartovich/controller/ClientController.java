package by.nenartovich.controller;


import by.nenartovich.*;
import by.nenartovich.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@AllArgsConstructor
@RequestMapping("/client")
@SessionAttributes({"person", "parameter", "filter", "basket"})
public class ClientController {
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;

    @GetMapping
    public String getOrders(@ModelAttribute("filter") OrderFilter orderFilter,
                            @ModelAttribute("person") ClientDto clientDto) {
        orderFilter.setClientName(clientDto.getName());
        return "redirect:/client/catalog";
    }

    @GetMapping("/order/new")
    public String newOrder(@ModelAttribute("person") ClientDto clientDto,
                           Model model) {
        OrderDto orderDto = new OrderDto();
        orderDto.setClient(clientDto);
        orderDto.setAddressDelivery(clientDto.getAddress());
        model.addAttribute("order", orderDto);
        model.addAttribute("deliverys", deliveryService.findAllDeliveryDto());
        return "/client/order-create";
    }

    @PostMapping("/orders")
    public String create(@ModelAttribute("order") OrderDto orderDto,
                         @ModelAttribute("basket") Basket basket, Principal principal) {
        orderDto.setProducts(basket.getBasket());
        orderDto.setStatusOrder(StatusOrder.PENDING_PROCESSING);
        orderDto.setClient(clientService.findByName(principal.getName()));
        orderDto.setPrice(basket.getBasket().stream()
                .mapToDouble(ProductDto::getPrice)
                .sum());
        orderService.save(orderDto);
        basket.clear();
        return "redirect:/client/orders";
    }

    @PatchMapping("/update")
    public String updateClient(@ModelAttribute("person") ClientDto clientDto) {
        clientService.updateClient(clientDto);
        return "redirect:/client/orders";
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