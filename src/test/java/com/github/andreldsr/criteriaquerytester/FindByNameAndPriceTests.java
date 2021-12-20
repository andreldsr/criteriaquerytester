package com.github.andreldsr.criteriaquerytester;

import com.github.andreldsr.criteriaquerytester.data.product.entity.Product;
import com.github.andreldsr.criteriaquerytester.data.product.repository.ProductCriteriaRepository;
import com.github.andreldsr.criteriaquerytester.data.product.repository.ProductCriteriaResolverRepository;
import com.github.andreldsr.criteriaquerytester.data.product.repository.ProductHQLRepository;
import com.github.andreldsr.criteriaquerytester.data.product.repository.ProductSpringRepository;
import com.github.andreldsr.criteriaquerytester.data.product.searchobject.ProductSearchObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FindByNameAndPriceTests {

    @Autowired
    private ProductSpringRepository productSpringRepository;

    @Autowired
    private ProductHQLRepository productRepository;

    @Autowired
    private ProductCriteriaRepository productCriteriaRepository;

    @Autowired
    private ProductCriteriaResolverRepository productCriteriaResolverRepository;

    private final String PRODUCT_NAME = "product name";
    private final Double PRODUCT_PRICE = 10.0;

    @Test
    void findProductWithSpringJPA() {
        List<Product> all = productSpringRepository.findByNameAndPrice(PRODUCT_NAME, PRODUCT_PRICE);
        assertNotNull(all);
        assertEquals(1, all.size());
    }

    @Test
    void findProductWithHQL() {
        List<Product> all = productRepository.findByNameAndPrice(PRODUCT_NAME, PRODUCT_PRICE);
        assertNotNull(all);
        assertEquals(1, all.size());
    }

    @Test
    void findProductWithCriteria() {
        List<Product> all = productCriteriaRepository.findByNameAndPrice(PRODUCT_NAME, PRODUCT_PRICE);
        assertNotNull(all);
        assertEquals(1, all.size());
    }

    @Test
    void findProductWithCriteriaResolver() {
        List<Product> all = productCriteriaResolverRepository.getResultList(ProductSearchObject.builder().name(PRODUCT_NAME).price(PRODUCT_PRICE).build());
        assertNotNull(all);
        assertEquals(1, all.size());
    }

}
