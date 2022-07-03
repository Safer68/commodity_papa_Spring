package by.nenartovich;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/orders")
    public String index(Model model) {
        model.addAttribute("orders", managerService.getManagerOrders(1L));
        return "orders-list";
    }
}