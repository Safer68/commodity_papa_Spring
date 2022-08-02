package by.nenartovich.rest;

import by.nenartovich.Basket;
import by.nenartovich.ProductService;
import by.nenartovich.dto.ProductDto;
import by.nenartovich.smsc_api.Smsc;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-catalog")
@RequiredArgsConstructor
public class CatalogRestController {
    /*private final ProductService productService;*/
    @GetMapping("/get")
    public String getProductClient(/*@ModelAttribute(BASKET) Basket basket, Model model*/) {
        /*List<ProductDto> productDtoList = productService.getByActive(true);
        model.addAttribute(PRODUCTS, productDtoList);
        *//*return CLIENT_CATALOG;*/
        return "CLIENT_CATALOG";
    }
}
