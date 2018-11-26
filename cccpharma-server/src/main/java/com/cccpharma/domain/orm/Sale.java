package com.cccpharma.domain.orm;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NonNull
    private Integer itemsQuantity;

    @Column
    @NonNull
    private Double finalValue;

    @OneToMany(mappedBy = "sale")
    private List<Item> items;
}
