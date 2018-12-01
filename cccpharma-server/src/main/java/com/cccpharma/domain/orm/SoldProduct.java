package com.cccpharma.domain.orm;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SoldProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Integer productsQuantity;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @NotNull
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;
}
