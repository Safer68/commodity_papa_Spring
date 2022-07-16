package by.nenartovich.controller;

import by.nenartovich.ManagerService;
import by.nenartovich.OrderFilter;
import by.nenartovich.Par;
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

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.ParseException;

@Controller
@AllArgsConstructor

@RequestMapping
public class OrderController {
    private final ManagerService managerService;

    @GetMapping("/manager/orders2")
    public String getOrders(@ModelAttribute("nam") Par par,
                            @ModelAttribute("filter") OrderFilter orderFilter,
                            @ModelAttribute("person") ManagerDto managerDto,
                            Model model,Principal principal) {
        System.out.println(managerDto+"------------------------------------------------------------------------------------------");
        //managerDto = managerService.findByName(principal.getName());
        /*System.out.println(managerDto);*/
        Page<OrderDto> page = managerService.findAllPaginated(orderFilter, par);
        par.setGetTotalPages(page.getTotalPages());
        par.setGetTotalElements(page.getTotalElements());
        model.addAttribute("orders", page);
        return "/manager/orders";
    }

}
