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
@SessionAttributes({"person", "parameter", "filter"})
public class ClientController {

    private final ManagerService managerService;
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;

    @GetMapping
    public String getOrders(@ModelAttribute("parameter") Parameter parameter,
                            @ModelAttribute("filter") OrderFilter orderFilter,
                            @ModelAttribute("person") ClientDto clientDto) {
        System.out.println(clientDto);
        orderFilter.setClientName(clientDto.getName());
        return "redirect:/client/orders";
    }

    /*@GetMapping("/order/new")
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
    }*/

   /* @PostMapping("/orders")
    public String create(@ModelAttribute("order") OrderDto orderDto,
                         @RequestParam("answerList") List<Long> answerList,
                         @ModelAttribute("address") AddressDto addressDto,
                         @ModelAttribute("client") ClientDto clientDto, Principal principal) {
        List<ProductDto> productDtos = answerList.stream()
                .map(productService::findById)
                .collect(toList());
        ManagerDto managerDto = managerService.findByName(principal.getName());
        clientDto.setAddress(addressDto);
        orderDto.setClient(clientService.save(clientDto));
        orderDto.setProducts(productDtos);
        orderDto.setManager(managerDto);
        orderService.save(orderDto);
        return "redirect:/manager/orders";
    }*/

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
}