package com.cccpharma.soldProduct;

import com.cccpharma.product.Product;
import com.cccpharma.sale.Sale;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "sale")
public class SoldProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer productsQuantity;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;
}
