package by.nenartovich.controller;


import by.nenartovich.ClientService;
import by.nenartovich.ManagerService;
import by.nenartovich.OrderService;
import by.nenartovich.dto.ClientDto;
import by.nenartovich.dto.OrderDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManagerController {

    private final ManagerService managerService;
    private final OrderService orderService;
    private final ClientService clientService;


    public ManagerController(ManagerService managerService, OrderService orderService, ClientService clientService) {
        this.managerService = managerService;
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @GetMapping("/orders")
    public String index(Model model) {
        model.addAttribute("orders", managerService.getManagerOrders(1L));
        return "orders-list";
    }
    @GetMapping("/order-create")
    public String newOrder(Model model) {
        OrderDto orderDto = new OrderDto();
        ClientDto clientDto = new ClientDto();
        model.addAttribute("order",orderDto);
        model.addAttribute("client",clientDto);
        return "order-create";
    }
    @PostMapping("/orders")
    public String create(@ModelAttribute("order") OrderDto orderDto,
                         @ModelAttribute("client") ClientDto clientDto) {
        orderDto.setClient(clientService.save(clientDto));
        orderService.saveOrder(orderDto);
        return "redirect:/orders";
    }
}