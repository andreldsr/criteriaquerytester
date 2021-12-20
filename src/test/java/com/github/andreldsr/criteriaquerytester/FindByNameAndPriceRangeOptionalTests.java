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
class FindByNameAndPriceRangeOptionalTests {

    @Autowired
    private ProductSpringRepository productSpringRepository;

    @Autowired
    private ProductHQLRepository productRepository;

    @Autowired
    private ProductCriteriaRepository productCriteriaRepository;

    @Autowired
    private ProductCriteriaResolverRepository productCriteriaResolverRepository;

    private final String PRODUCT_NAME = null;//"product name";
    private final Double PRODUCT_MIN_PRICE = 5.0;
    private final Double PRODUCT_MAX_PRICE = 20.0;
    private final int EXPECTED = 1;

    @Test
    void findProductWithSpringJPA() {
        List<Product> all = productSpringRepository.findByNameAndPriceBetweenOptional(PRODUCT_NAME, PRODUCT_MIN_PRICE, PRODUCT_MAX_PRICE);
        assertNotNull(all);
//        assertEquals(EXPECTED, all.size());
    }

    @Test
    void findProductWithHQL() {
        List<Product> all = productRepository.findByNameAndPriceBetweenOptional(PRODUCT_NAME, PRODUCT_MIN_PRICE, PRODUCT_MAX_PRICE);
        assertNotNull(all);
//        assertEquals(EXPECTED, all.size());
    }


    @Test
    void findProductWithCriteria() {
        List<Product> all = productCriteriaRepository.findByNameAndPriceBetweenOptional(PRODUCT_NAME, PRODUCT_MIN_PRICE, PRODUCT_MAX_PRICE);
        assertNotNull(all);
//        assertEquals(EXPECTED, all.size());
    }


    @Test
    void findProductWithCriteriaResolver() {
        List<Product> all = productCriteriaResolverRepository.getResultList(
                ProductSearchObject.builder()
                        .name(PRODUCT_NAME)
                        .minPrice(PRODUCT_MIN_PRICE)
                        .maxPrice(PRODUCT_MAX_PRICE)
                        .build());
        assertNotNull(all);
//        assertEquals(EXPECTED, all.size());
    }
    @Test
    void findProductWithCriteriaResolverWithoutBuilder() {
        ProductSearchObject productSearchObject = new ProductSearchObject();
        productSearchObject.setName(PRODUCT_NAME);
        productSearchObject.setMinPrice(PRODUCT_MIN_PRICE);
        productSearchObject.setMaxPrice(PRODUCT_MAX_PRICE);
        List<Product> all = productCriteriaResolverRepository.getResultList(productSearchObject);
        assertNotNull(all);
//        assertEquals(EXPECTED, all.size());
    }

    @Test
    void compareTestResults(){
        List<Product> springResult = productSpringRepository.findByNameAndPriceBetweenOptional(PRODUCT_NAME, PRODUCT_MIN_PRICE, PRODUCT_MAX_PRICE);
        List<Product> hqlResult = productRepository.findByNameAndPriceBetweenOptional(PRODUCT_NAME, PRODUCT_MIN_PRICE, PRODUCT_MAX_PRICE);
        List<Product> criteriaResult = productCriteriaRepository.findByNameAndPriceBetweenOptional(PRODUCT_NAME, PRODUCT_MIN_PRICE, PRODUCT_MAX_PRICE);
        List<Product> criteriaResolverResult = productCriteriaResolverRepository.getResultList(
                ProductSearchObject.builder()
                        .name(PRODUCT_NAME)
                        .minPrice(PRODUCT_MIN_PRICE)
                        .maxPrice(PRODUCT_MAX_PRICE)
                        .build());

        assertEquals(criteriaResolverResult.size(), springResult.size());
        assertEquals(criteriaResolverResult.size(), hqlResult.size());
        assertEquals(criteriaResolverResult.size(), criteriaResult.size());
    }
}
