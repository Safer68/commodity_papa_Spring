package by.nenartovich.rest;

import by.nenartovich.ProductService;
import by.nenartovich.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-catalog")
@RequiredArgsConstructor
public class CatalogRestController {
    private final ProductService productService;
    @GetMapping("/get")
    public List<ProductDto> getProductClient(/*@ModelAttribute(BASKET) Basket basket, Model model*/) {
        List<ProductDto> productDtoList = productService.getByActive(true);
        return productDtoList;
    }
}
