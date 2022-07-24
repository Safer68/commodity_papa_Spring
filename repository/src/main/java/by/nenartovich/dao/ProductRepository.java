package by.nenartovich.dao;

import by.nenartovich.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getByActive(boolean active);
}