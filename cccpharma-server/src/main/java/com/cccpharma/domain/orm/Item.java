package com.cccpharma.domain.orm;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NonNull
    private Integer productsQuantity;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    @NonNull
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NonNull
    private Product product;
}
