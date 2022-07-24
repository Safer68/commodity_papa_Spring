package by.nenartovich.impl;


import by.nenartovich.ProductService;
import by.nenartovich.dao.ProductRepository;
import by.nenartovich.dto.ProductDto;
import by.nenartovich.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public void save(ProductDto productDto) {
        productRepository.save(productMapper.productDtoToProduct(productDto));
    }

    @Override
    public ProductDto findById(Long productId) {
        return productMapper.productToProductDto(productRepository.getReferenceById(productId));
    }

    @Override
    public List<ProductDto> findAllProductDto() {
        return productRepository.findAll().stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getByActive(boolean active) {

        return productRepository.getByActive(active).stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

   /* @Override
    public void updateProduct(ProductDto productDto) {
        productRepository.save(productMapper.productDtoToProduct(productDto));
    }*/

    /*@Override
    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }*/
}
