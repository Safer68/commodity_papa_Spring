package by.nenartovich.controller;

import by.nenartovich.Basket;
import by.nenartovich.ProductService;
import by.nenartovich.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@SessionAttributes("basket")
public class BasketController {

    private final ProductService productService;
   /* @GetMapping("/basket")
    public String get(Model model) {
        List<ProductDto> productDtos = basket.getBasket();
        model.addAttribute("basket", productDtos);
        model.addAttribute("product", new ProductDto());
        return "basket";
    }*/
   @PostMapping("/basket/add")
   public String add(@ModelAttribute("productId")Long productId,
                     @ModelAttribute("basket") Basket basket) {
       System.out.println("-----------------------------------------------");
       System.out.println(productId);
       System.out.println(productService.findById(productId));
       basket.add(productService.findById(productId));
       System.out.println(basket.getSize());
       return  "redirect:/";
   }
    @DeleteMapping("/basket/remove")
    public String remove(@ModelAttribute("productId")Long productId,
                      @ModelAttribute("basket") Basket basket) {
        System.out.println("-----------------------------------------------");
        System.out.println(productId);
        System.out.println(productService.findById(productId));
        basket.remove(productService.findById(productId));
        System.out.println(basket.getSize());
        return  "redirect:/client/order/new";
    }
}