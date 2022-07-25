package by.nenartovich.controller;

import by.nenartovich.Basket;
import by.nenartovich.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@AllArgsConstructor
@Controller
@SessionAttributes("basket")
public class BasketController {

    private static final String PRODUCT_ID = "productId";
    private static final String BASKET = "basket";
    private static final String REDIRECT_CLIENT_ORDER_NEW = "redirect:/client/order/new";
    private final ProductService productService;

    @PostMapping("/basket/add")
    public String add(@ModelAttribute(PRODUCT_ID) Long productId,
                      @ModelAttribute(BASKET) Basket basket) {
        basket.add(productService.findById(productId));
        System.out.println(basket.getSize());
        return "redirect:/";
    }

    @DeleteMapping("/basket/remove")
    public String remove(@ModelAttribute(PRODUCT_ID) Long productId,
                         @ModelAttribute(BASKET) Basket basket) {
        basket.remove(productService.findById(productId));
        System.out.println(basket.getSize());
        return REDIRECT_CLIENT_ORDER_NEW;
    }
}