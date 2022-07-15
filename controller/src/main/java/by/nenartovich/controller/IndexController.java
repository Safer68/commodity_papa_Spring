package by.nenartovich.controller;

import by.nenartovich.*;
import by.nenartovich.dao.ClientRepository;
import by.nenartovich.dao.UserRepository;
import by.nenartovich.dto.ManagerDto;
import by.nenartovich.entity.Role;
import by.nenartovich.entity.User;
import liquibase.pro.packaged.r;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Objects;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/")
@SessionAttributes({"person", "nam", "filter"})
public class IndexController {

    private final UserRepository userRepository;

    @GetMapping("/index")
    public String index(Principal principal) {
        Set<Role> roles = userRepository.findByUserName(principal.getName()).getRoles();

        for (Role role : roles) {
            if (Objects.equals(role.getName(), "ADMIN")) {
                return "redirect:/manager";
            }
        }
        return "login";
    }
    @ModelAttribute("person")
    public ManagerDto populatePerson() {
        return ManagerDto.builder().build();
        //return managerService.findByName(principal.getName());
        //return ManagerDto.builder().build();
    }

    @ModelAttribute("nam")
    public Par populateName() {
        return Par.builder().build();
    }

    @ModelAttribute("filter")
    public OrderFilter populateFilter() {
        return OrderFilter.builder().build();
    }
}
