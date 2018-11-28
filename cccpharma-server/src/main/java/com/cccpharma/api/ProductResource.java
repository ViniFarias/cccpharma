package com.cccpharma.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="product", collectionRelation="products")
public class ProductResource extends ResourceSupport {

    private String barcode;
    private String name;
    private boolean available;
    private Double price;
    private String categoryName;
    private Double categoryDiscount;
    private String manufacturer;
}
