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
    private String name;

    @Column
    private String manufacturer;

    @Column
    @NonNull
    private boolean available;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
