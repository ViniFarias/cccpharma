package com.cccpharma.product;

import com.cccpharma.category.Category;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The {@code Product} class represents a product.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    /**
     * The product bar code.
     * It's the product identifier.
     */
    @Id
    @NotNull
    private String barcode;

    /**
     * The product name.
     */
    @NotNull
    private String name;

    /**
     * The product manufacturer.
     */
    @NotNull
    private String manufacturer;

    /**
     * The product availability.
     */
    @NotNull
    private boolean available;

    /**
     * The product price.
     */
    @NotNull
    private Double price;

    /**
     * The category to which the product is associated.
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

}
