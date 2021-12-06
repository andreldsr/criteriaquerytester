package com.github.andreldsr.criteriaquerytester.data.product.repository;

import com.github.andreldsr.criteriaquerytester.data.product.entity.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductHQLRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll(){
        String hql = "SELECT p FROM Product p";
        TypedQuery<Product> query = em.createQuery(hql, Product.class);
        return query.getResultList();
    }

    public List<Product> findByName(String name){
        String hql = "SELECT p FROM Product p WHERE p.name = :name";
        TypedQuery<Product> query = em.createQuery(hql, Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Product> findByNameAndPrice(String name, Double price) {
        String hql = "SELECT p FROM Product p WHERE p.name = :name AND p.price = :price";
        TypedQuery<Product> query = em.createQuery(hql, Product.class);
        query.setParameter("name", name);
        query.setParameter("price", price);
        return query.getResultList();
    }

    public List<Product> findByNameAndPriceBetween(String name, Double minPrice, Double maxPrice) {
        String hql = "SELECT p FROM Product p WHERE p.name = :name AND p.price between :minPrice and :maxPrice";
        TypedQuery<Product> query = em.createQuery(hql, Product.class);
        query.setParameter("name", name);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        return query.getResultList();
    }
}
