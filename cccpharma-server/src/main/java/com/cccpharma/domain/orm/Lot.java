package com.cccpharma.domain.orm;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lot {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NonNull
    private Date expirationDate;

    @Column
    @NonNull
    private Integer productsQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NonNull
    private Product product;

}
