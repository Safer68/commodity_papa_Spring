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

    private final ManagerService managerService;
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;
    private final UserService userService;

    @GetMapping
    public String getOrders(@ModelAttribute("parameter") Parameter parameter,
                            @ModelAttribute("filter") OrderFilter orderFilter,
                            @ModelAttribute("person") ManagerDto managerDto) {
        orderFilter.setManagerName(managerDto.getName());
        return "redirect:/manager/orders";
    }

    @GetMapping("/order/new")
    public String newOrder(Model model) {
        OrderDto orderDto = new OrderDto();
        ClientDto clientDto = new ClientDto();
        AddressDto addressDto = new AddressDto();
        model.addAttribute("order", orderDto);
        model.addAttribute("client", clientDto);
        model.addAttribute("address", addressDto);
        model.addAttribute("deliverys", deliveryService.findAllDeliveryDto());
        model.addAttribute("products", productService.findAllProductDto());
        return "/manager/order-create";
    }

    @PostMapping("/orders")
    public String create(@ModelAttribute("order") OrderDto orderDto,
                         @RequestParam("productList") List<Long> answerList,
                         @ModelAttribute("address") AddressDto addressDto,
                         @ModelAttribute("client") ClientDto clientDto, Principal principal) {
        List<ProductDto> productDtos = answerList.stream()
                .map(productService::findById)
                .collect(toList());
        ManagerDto managerDto = managerService.findByName(principal.getName());
        UserDto userDto = UserDto.builder()
                .userName(clientDto.getEmail())
                .build();
        clientDto.setUser(userService.saveUser(userDto,"CLIENT"));
        clientDto.setAddress(addressDto);
        orderDto.setClient(clientService.save(clientDto));
        orderDto.setProducts(productDtos);
        orderDto.setPrice(productDtos.stream()
                .mapToDouble(ProductDto::getPrice)
                .sum());
        orderDto.setManager(managerDto);
        orderDto.setStatusOrder(StatusOrder.ACCEPTED_BY_MANAGER);
        orderService.save(orderDto);
        return "redirect:/manager/orders";
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