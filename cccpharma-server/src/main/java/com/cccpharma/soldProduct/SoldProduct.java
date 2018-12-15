package com.cccpharma.soldProduct;

import com.cccpharma.product.Product;
import com.cccpharma.sale.Sale;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * The {@code SoldProduct} class represents a sold product.
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
@ToString(exclude = "sale")
public class SoldProduct {

    /**
     * The sold product identifier.
     * It's generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The quantity of sold products.
     */
    @NotNull
    private Integer productsQuantity;

    /**
     * The sale to which the product sold is linked.
     * This attribute are not returned in the json that represents the sold product.
     */
    @ManyToOne
    @JoinColumn(name = "sale_id")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Sale sale;

    /**
     * The product to which the product sold is linked.
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;
}
