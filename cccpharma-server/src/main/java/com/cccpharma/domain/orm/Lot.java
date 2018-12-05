package com.cccpharma.domain.orm;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @NotNull
    private Date expirationDate;

    @NotNull
    private Integer productsQuantityTotal;

    @NotNull
    private Integer availableProductsQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

}
