package com.cccpharma.domain.orm;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    @NotNull
    private String barcode;

    @NotNull
    private String name;

    @NotNull
    private String manufacturer;

    @NotNull
    private boolean available;

    @NotNull
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

}
