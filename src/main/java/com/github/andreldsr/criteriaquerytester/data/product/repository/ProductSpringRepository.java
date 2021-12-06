package com.github.andreldsr.criteriaquerytester.data.product.repository;

import com.github.andreldsr.criteriaquerytester.data.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSpringRepository extends JpaRepository<Product, Long> {
    public List<Product> findByName(String name);
    public List<Product> findByNameLike(String name);

    public List<Product> findByNameAndPrice(String name, Double price);

    public List<Product> findByNameAndPriceBetween(String product_name, Double product_min_price, Double product_max_price);
}
