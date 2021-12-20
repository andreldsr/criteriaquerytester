package com.github.andreldsr.criteriaquerytester.data.product.repository;

import com.github.andreldsr.criteriaquerytester.data.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSpringRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByNameAndPrice(String name, Double price);

    List<Product> findByNameAndPriceBetween(String productName, Double productMinPrice, Double productMaxPrice);

    @Query("SELECT p FROM Product p WHERE (:productName = null or p.name = :productName) " +
            "AND (:productMinPrice = null or p.price >= :productMinPrice) " +
            "AND (:productMaxPrice = null or p.price <= :productMaxPrice)")
    List<Product> findByNameAndPriceBetweenOptional(String productName, Double productMinPrice, Double productMaxPrice);
}
