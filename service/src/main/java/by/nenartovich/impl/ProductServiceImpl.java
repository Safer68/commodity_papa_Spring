package by.nenartovich.impl;


import by.nenartovich.ProductService;
import by.nenartovich.dao.ProductRepository;
import by.nenartovich.dto.ProductDto;
import by.nenartovich.mappers.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void createProduct(ProductDto productDto) {
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
    public void updateProduct(ProductDto productDto) {
        productRepository.save(productMapper.productDtoToProduct(productDto));
    }

    @Override
    public void removeProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
