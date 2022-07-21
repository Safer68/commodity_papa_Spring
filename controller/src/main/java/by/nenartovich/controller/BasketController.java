package by.nenartovich.controller;

import by.nenartovich.Basket;
import by.nenartovich.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class BasketController {

    private final Basket basket;

    @GetMapping("/basket")
    public String get(Model model) {
        List<ProductDto> productDtos = basket.getBasket();
        model.addAttribute("basket", productDtos);
        model.addAttribute("product", new ProductDto());
        return "basket";
    }
    @PostMapping("/basket")
    public String add(ProductDto productDto) {
        basket.add(productDto);
        return  "redirect:/";
    }
}