package by.nenartovich.controller;

import by.nenartovich.Basket;
import by.nenartovich.UserService;
import by.nenartovich.dto.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;
import java.util.Objects;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    private static final String BASKET = "basket";
    private static final String MANAGER = "MANAGER";
    private static final String REDIRECT_MANAGER = "redirect:/manager";
    private static final String CLIENT = "CLIENT";
    /*private static final String REDIRECT_CLIENT = "redirect:/client";*/
    private static final String REDIRECT_CLIENT = "redirect:/rest-catalog/get";
    private static final String LOGIN = "login";
    private final UserService userService;

    @GetMapping()
    public String index( @ModelAttribute(BASKET) Basket basket,
                         Principal principal) {
        Set<RoleDto> roles = userService.getRoleUser(principal.getName());
        for (RoleDto role : roles) {
            if (Objects.equals(role.getName(), MANAGER)) {
                return REDIRECT_MANAGER;
            }
            if (Objects.equals(role.getName(), CLIENT)) {
                return REDIRECT_CLIENT;
            }
        }
        return LOGIN;
    }
}
