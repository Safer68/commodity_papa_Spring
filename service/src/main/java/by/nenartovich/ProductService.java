package by.nenartovich;


import by.nenartovich.dto.ProductDto;

import java.util.List;

public interface ProductService {
    /* void createProduct(ProductDto productDto);*/

    ProductDto findById(Long productId);

    List<ProductDto> findAllProductDto();

    /*void updateProduct(ProductDto productDto);*/

    /*void removeProduct(Long productId);*/
}
