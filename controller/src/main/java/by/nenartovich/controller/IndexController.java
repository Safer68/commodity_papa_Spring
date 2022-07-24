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

    private final UserService userService;

    @GetMapping()
    public String index( @ModelAttribute("basket") Basket basket,
                         Principal principal) {
        Set<RoleDto> roles = userService.getRoleUser(principal.getName());
        for (RoleDto role : roles) {
            if (Objects.equals(role.getName(), "MANAGER")) {
                return "redirect:/manager";
            }
            if (Objects.equals(role.getName(), "CLIENT")) {
                return "redirect:/client";
            }
        }
        return "login";
    }
}
