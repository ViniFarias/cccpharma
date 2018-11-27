package com.cccpharma.domain.orm;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String barcode;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private String manufacturer;

    @Column
    @NonNull
    private boolean available;

    @Column
    @NonNull
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Lot> lots;

    @OneToMany(mappedBy = "product")
    private List<Item> items;
}
