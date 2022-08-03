package by.nenartovich.controller;

import by.nenartovich.OrderFilter;
import by.nenartovich.OrderService;
import by.nenartovich.Parameter;
import by.nenartovich.StatusOrder;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.dto.OrderDto;
import by.nenartovich.rest.feign.SimpleClient;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@AllArgsConstructor
@RequestMapping
@SessionAttributes({"person", "parameter", "filter", "basket"})
public class OrderController {
    private static final String PARAMETER = "parameter";
    private static final String FILTER = "filter";
    private static final String PERSON = "person";
    private static final String ORDERS = "orders";
    private static final String ORD = "ord";
    private static final String ID = "id";
    private static final String ORDER = "order";
    private static final String REDIRECT_MANAGER_ORDERS = "redirect:/manager/orders";
    private static final String CLIENT_ORDER = "client/order";
    private final OrderService orderService;
    private final SimpleClient simpleClient;

    @GetMapping("/manager/orders")
    public String getManagerOrders(@ModelAttribute(PARAMETER) Parameter parameter,
                                   @ModelAttribute(FILTER) OrderFilter orderFilter,
                                   @ModelAttribute(PERSON) ManagerDto managerDto,
                                   Model model) {
        Page<OrderDto> page = orderService.findAllPaginated(orderFilter, parameter);
        parameter.setGetTotalPages(page.getTotalPages());
        parameter.setGetTotalElements(page.getTotalElements());
        model.addAttribute(ORDERS, page);
        model.addAttribute(ORD, new OrderDto());
        return "manager/orders";
    }

    @GetMapping("/client/orders")
    public String getClientOrders(@ModelAttribute(PARAMETER) Parameter parameter,
                                  @ModelAttribute(FILTER) OrderFilter orderFilter,
                                  Model model) {
        Page<OrderDto> page = orderService.findAllPaginated(orderFilter, parameter);
        parameter.setGetTotalPages(page.getTotalPages());
        parameter.setGetTotalElements(page.getTotalElements());
        model.addAttribute(ORDERS, page);
        return "client/orders";
    }

    @GetMapping("/manager/orders/{id}")
    public String getOrdersManager(Model model, @PathVariable(ID) long id) {
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute(ORDER, orderDto);
        return "manager/order";
    }

    @PatchMapping("/manager/orders/{id}")
    public String update(@ModelAttribute(ORDER) OrderDto orderDto) {
        orderDto.setStatusOrder(StatusOrder.ACCEPTED_BY_MANAGER);
        orderService.updateOrder(orderDto);
        return REDIRECT_MANAGER_ORDERS;
    }

    @GetMapping("/client/orders/{id}")
    public String getOrdersClient(Model model, @PathVariable(ID) long id) {
        OrderDto orderDto = orderService.findById(id);
        model.addAttribute(ORDER, orderDto);
        return CLIENT_ORDER;
    }

    @PostMapping("/manager/orders/SMS/{id}")
    public String getSMS(@PathVariable(ID) long id) {
        OrderDto orderDto = orderService.findById(id);
        orderDto.setSmsSending(Arrays.toString(simpleClient.getSMS(orderDto.getClient().getPhoneNumber())));
        orderService.updateOrder(orderDto);
        return "redirect:/manager/orders/"+id;
    }
}
