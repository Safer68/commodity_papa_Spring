package by.nenartovich.controller;


import by.nenartovich.Basket;
import by.nenartovich.ProductService;
import by.nenartovich.dto.ProductDto;
import by.nenartovich.utils.FileNameUtils;
import by.nenartovich.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
@SessionAttributes({"basket", "person"})
public class CatalogController {
    private static final String PRODUCTS = "products";
    private static final String PRODUCT_DTO = "productDto";
    private static final String MANAGER_CATALOG = "/manager/catalog";
    private static final String PRODUCT = "product";
    private static final String MANAGER_PRODUCT = "/manager/product";
    private static final String CLIENT_CATALOG = "/catalog";
    private static final String BASKET = "basket";
    private static final String ID = "id";
    private static final String CLIENT_PRODUCT = "/client/product";
    private static final String FILE = "file";
    private static final String REDIRECT_MANAGER_CATALOG = "redirect:/manager/catalog";
    private final ProductService productService;

    @GetMapping("/manager/catalog")
    public String getProductsManager(Model model) {
        List<ProductDto> productDtoList = productService.findAllProductDto();
        model.addAttribute(PRODUCTS, productDtoList);
        model.addAttribute(PRODUCT_DTO, new ProductDto());
        return MANAGER_CATALOG;
    }

    @GetMapping("/manager/product/new")
    public String getProduct(Model model) {
        model.addAttribute(PRODUCT, new ProductDto());
        return MANAGER_PRODUCT;
    }

    @GetMapping("/client/catalog")
    public String getProductClient(@ModelAttribute(BASKET) Basket basket, Model model) {
        List<ProductDto> productDtoList = productService.getByActive(true);
        model.addAttribute(PRODUCTS, productDtoList);
        /*return CLIENT_CATALOG;*/
        return "CLIENT_CATALOG";
    }

    @GetMapping("/client/product/{id}")
    public String getProductClient(Model model, @PathVariable(ID) long id) {
        ProductDto productDto = productService.findById(id);
        model.addAttribute(PRODUCT, productDto);
        return CLIENT_PRODUCT;
    }

    @GetMapping("/manager/product/update/{id}")
    public String getProduct(Model model, @PathVariable(ID) long id) {
        ProductDto productDto = productService.findById(id);
        model.addAttribute(PRODUCT, productDto);
        return MANAGER_PRODUCT;
    }

    @PostMapping("/manager/catalog")
    public String createProducts(@ModelAttribute(PRODUCT) ProductDto productDto,
                                 @Value("${web.upload-path}") String path,
                                 @RequestParam(FILE) MultipartFile file) {
        if (0 != file.getSize()) {
            String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
            if (FileUtils.upload(file, path, fileName)) {
                productDto.setImage(fileName);
            }
        } else {
            productDto.setImage("fbf18823c6a04177bd97b146d2341388.png");
        }
        productService.save(productDto);
        return REDIRECT_MANAGER_CATALOG;
    }

    @PatchMapping("/manager/product/update/{id}")
    public String proUpdate(@ModelAttribute(PRODUCT) ProductDto productDto,
                            @Value("${web.upload-path}") String path,
                            @RequestParam(FILE) MultipartFile file) {
        if (0 != file.getSize()) {
            String fileName = FileNameUtils.getFileName(file.getOriginalFilename());
            if (FileUtils.upload(file, path, fileName)) {
                productDto.setImage(fileName);
            }
        }
        productService.save(productDto);
        return REDIRECT_MANAGER_CATALOG;
    }
}