package com.cccpharma.lot;

import com.cccpharma.product.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * The {@code Lot} class represents a lot.
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
public class Lot {

    /**
     * The lot identifier.
     * It's generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The expiration date of the lot.
     * Returned in the json that represents the lot in the format 'dd/MM/yyyy'.
     */
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @NotNull
    private Date expirationDate;

    /**
     * The initial quantity of products in the lot.
     */
    @NotNull
    private Integer productsQuantityTotal;

    /**
     * The quantity of available products in the lot.
     */
    @NotNull
    private Integer availableProductsQuantity;

    /**
     * The product to which the lot is associated.
     */
    @ManyToOne
    @JoinColumn(name = "product_id")
    @NotNull
    private Product product;

}
