package by.nenartovich;


import by.nenartovich.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void save(ProductDto productDto);

    ProductDto findById(Long productId);

    List<ProductDto> findAllProductDto();

    List<ProductDto> getByActive(boolean active);

}
