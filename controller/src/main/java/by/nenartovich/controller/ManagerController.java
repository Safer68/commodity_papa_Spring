package by.nenartovich.controller;


import by.nenartovich.*;
import by.nenartovich.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@AllArgsConstructor
@RequestMapping("/manager")
@SessionAttributes({"person", "parameter", "filter"})
public class ManagerController {

    private static final String PARAMETER = "parameter";
    private static final String FILTER = "filter";
    private static final String PERSON = "person";
    private static final String REDIRECT_MANAGER_ORDERS = "redirect:/manager/orders";
    private static final String ORDER = "order";
    private static final String CLIENT = "client";
    private static final String ADDRESS = "address";
    private static final String DELIVERYS = "deliverys";
    private static final String PRODUCTS = "products";
    private static final String MANAGER_ORDER_CREATE = "manager/order-create";
    private static final String PRODUCT_LIST = "productList";
    private final ManagerService managerService;
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;
    private final UserService userService;

    @GetMapping
    public String getOrders(@ModelAttribute(PARAMETER) Parameter parameter,
                            @ModelAttribute(FILTER) OrderFilter orderFilter,
                            @ModelAttribute(PERSON) ManagerDto managerDto) {
        orderFilter.setManagerName(managerDto.getName());
        return REDIRECT_MANAGER_ORDERS;
    }

    @GetMapping("/order/new")
    public String newOrder(Model model) {
        OrderDto orderDto = new OrderDto();
        ClientDto clientDto = new ClientDto();
        AddressDto addressDto = new AddressDto();
        model.addAttribute(ORDER, orderDto);
        model.addAttribute(CLIENT, clientDto);
        model.addAttribute(ADDRESS, addressDto);
        model.addAttribute(DELIVERYS, deliveryService.findAllDeliveryDto());
        model.addAttribute(PRODUCTS, productService.findAllProductDto());
        return MANAGER_ORDER_CREATE;
    }

    @PostMapping("/orders")
    public String create(@ModelAttribute(ORDER) OrderDto orderDto,
                         @RequestParam(PRODUCT_LIST) List<Long> answerList,
                         @ModelAttribute(ADDRESS) AddressDto addressDto,
                         @ModelAttribute(CLIENT) ClientDto clientDto, Principal principal) {
        List<ProductDto> productDtos = answerList.stream()
                .map(productService::findById)
                .collect(toList());
        ManagerDto managerDto = managerService.findByName(principal.getName());
        UserDto userDto = UserDto.builder()
                .userName(clientDto.getEmail())
                .build();
        clientDto.setUser(userService.saveUser(userDto, "CLIENT"));
        clientDto.setAddress(addressDto);
        orderDto.setAddressDelivery(clientDto.getAddress());
        orderDto.setClient(clientService.save(clientDto));
        orderDto.setProducts(productDtos);
        orderDto.setPrice(productDtos.stream()
                .mapToDouble(ProductDto::getPrice)
                .sum());
        orderDto.setManager(managerDto);
        if (orderDto.getTrackNumber() == null || "".equals(orderDto.getTrackNumber())) {
            orderDto.setStatusOrder(StatusOrder.ACCEPTED_BY_MANAGER);
        } else {
            orderDto.setStatusOrder(StatusOrder.SENT);
        }
        orderService.save(orderDto);
        return REDIRECT_MANAGER_ORDERS;
    }

    @ModelAttribute("person")
    public ManagerDto populatePerson(Principal principal) {
        return managerService.findByName(principal.getName());
    }

    @ModelAttribute("parameter")
    public Parameter populateName() {
        return Parameter.builder().build();
    }

    @ModelAttribute("filter")
    public OrderFilter populateFilter() {
        return OrderFilter.builder().build();
    }
}