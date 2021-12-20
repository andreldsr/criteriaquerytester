package com.github.andreldsr.criteriaquerytester.data.product.searchobject;

import com.github.andreldsr.criteriaresolver.annotation.CriteriaField;
import com.github.andreldsr.criteriaresolver.searchobject.SearchObject;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchObject extends SearchObject {
    @CriteriaField
    private String name;
    @CriteriaField
    private Double price;
    @CriteriaField(fieldName = "price", comparationType = CriteriaField.ComparationType.GREATER_EQUALS)
    private Double minPrice;
    @CriteriaField(fieldName = "price", comparationType = CriteriaField.ComparationType.LESS_EQUALS)
    private Double maxPrice;
}
