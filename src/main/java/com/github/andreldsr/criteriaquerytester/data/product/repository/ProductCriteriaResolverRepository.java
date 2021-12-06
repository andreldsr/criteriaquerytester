package com.github.andreldsr.criteriaquerytester.data.product.repository;

import com.github.andreldsr.criteriaquerytester.data.product.entity.Product;
import com.github.andreldsr.criteriaresolver.repository.CriteriaResolverBaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ProductCriteriaResolverRepository extends CriteriaResolverBaseRepository<Product> {
    public ProductCriteriaResolverRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
