package by.nenartovich.controller;

import by.nenartovich.OrderFilter;
import by.nenartovich.OrderService;
import by.nenartovich.Parameter;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.dto.OrderDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@AllArgsConstructor
@RequestMapping
@SessionAttributes({"person", "parameter", "filter"})
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

}
