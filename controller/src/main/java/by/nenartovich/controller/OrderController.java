package by.nenartovich.controller;

import by.nenartovich.OrderFilter;
import by.nenartovich.OrderService;
import by.nenartovich.Parameter;
import by.nenartovich.StatusOrder;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.dto.OrderDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping
@SessionAttributes({"person", "parameter", "filter","basket"})
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/manager/orders")
    public String getManagerOrders(@ModelAttribute("parameter") Parameter parameter,
                                   @ModelAttribute("filter") OrderFilter orderFilter,
                                   @ModelAttribute("person") ManagerDto managerDto,
                                   Model model) {
        Page<OrderDto> page = orderService.findAllPaginated(orderFilter, parameter);
        parameter.setGetTotalPages(page.getTotalPages());
        parameter.setGetTotalElements(page.getTotalElements());
        model.addAttribute("orders", page);
        model.addAttribute("ord", new OrderDto());
        return "/manager/orders";
    }

    @GetMapping("/client/orders")
    public String getClientOrders(@ModelAttribute("parameter") Parameter parameter,
                            @ModelAttribute("filter") OrderFilter orderFilter,
                            /*@ModelAttribute("person") ManagerDto managerDto,*/
                            Model model) {
        Page<OrderDto> page = orderService.findAllPaginated(orderFilter, parameter);
        parameter.setGetTotalPages(page.getTotalPages());
        parameter.setGetTotalElements(page.getTotalElements());
        model.addAttribute("orders", page);
        return "/client/orders";
    }

    @GetMapping("/manager/orders/{id}")
    public String getOrdersManager(Model model, @PathVariable("id") long id) {
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order", orderDto);
        return "/manager/order";
    }
    @PatchMapping("/manager/orders/{id}")
    public String update(@ModelAttribute("order") OrderDto orderDto) {
        orderDto.setStatusOrder(StatusOrder.ACCEPTED_BY_MANAGER);
        orderService.updateOrder(orderDto);
        return "redirect:/manager/orders";
    }
    @GetMapping("/client/orders/{id}")
    public String getOrdersClient(Model model, @PathVariable("id") long id) {
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute("order", orderDto);
        return "/client/order";
    }

}
