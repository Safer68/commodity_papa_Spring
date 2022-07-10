package by.nenartovich.controller;


import by.nenartovich.*;
import by.nenartovich.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;
    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliveryService deliveryService;
    private final ProductService productService;

    public ManagerController(ManagerService managerService, OrderService orderService, ClientService clientService, DeliveryService deliveryService, ProductService productService) {
        this.managerService = managerService;
        this.orderService = orderService;
        this.clientService = clientService;
        this.deliveryService = deliveryService;
        this.productService = productService;
    }

    @GetMapping("/orders")
    public String showHorsesFirstPage(Model model, Principal principal) {
        return index(1, "id", "asc", model, principal);
    }

    @GetMapping("/orders/{pageNumber}")
    public String index(@PathVariable(value = "pageNumber") int pageNumber, @RequestParam("sortField") String sortField,
                        @RequestParam("sortDir") String sortDir, Model model, Principal principal) {
        String managerName = principal.getName();
        ManagerDto managerDto = managerService.findByName(principal.getName());
        Page<OrderDto> page = managerService.findAllPaginated(pageNumber, sortField, sortDir, managerDto.getId());
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<OrderDto> orders = page.getContent();
        model.addAttribute("currentPage", pageNumber);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("orders", page);
        model.addAttribute("manager", managerName);
        return "/manager/orders";
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
                         @RequestParam("answerList") Long[] answerList,
                         @ModelAttribute("address") AddressDto addressDto,
                         @ModelAttribute("client") ClientDto clientDto, Principal principal) {
        List<Long> list = new ArrayList<>();
        Collections.addAll(list, answerList);
        List<ProductDto> productDtos = list.stream().map(productService::findById).collect(Collectors.toList());
        ManagerDto managerDto = managerService.findByName(principal.getName());
        clientDto.setAddress(addressDto);
        orderDto.setClient(clientService.save(clientDto));
        orderDto.setProducts(productDtos);
        orderDto.setManager(managerDto);
        orderService.save(orderDto);
        return "redirect:/manager/orders";
    }
}