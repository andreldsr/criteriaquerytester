package com.github.andreldsr.criteriaquerytester.data.product.repository;

import com.github.andreldsr.criteriaquerytester.data.product.entity.Product;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductCriteriaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Product> findAll(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        query.from(Product.class);
        return em.createQuery(query).getResultList();
    }

    public List<Product> findByName(String name){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        query.where(criteriaBuilder.equal(root.get("name"), name));
        return em.createQuery(query).getResultList();
    }

    public List<Product> findByNameAndPrice(String name, Double price) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("name"), name));
        predicates.add(criteriaBuilder.equal(root.get("price"), price));
        query.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();
    }

    public List<Product> findByNameAndPriceBetween(String name, Double minPrice, Double maxPrice) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("name"), name));
        predicates.add(criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
        query.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();
    }

    public List<Product> findByNameAndPriceBetweenOptional(String name, Double minPrice, Double maxPrice) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if(name != null)
            predicates.add(criteriaBuilder.equal(root.get("name"), name));
        if(minPrice != null)
            predicates.add(criteriaBuilder.ge(root.get("price"), minPrice));
        if(maxPrice != null)
            predicates.add(criteriaBuilder.le(root.get("price"), maxPrice));
        query.where(predicates.toArray(new Predicate[0]));
        return em.createQuery(query).getResultList();
    }
}
