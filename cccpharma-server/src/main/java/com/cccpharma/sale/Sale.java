package com.cccpharma.sale;

import com.cccpharma.soldProduct.SoldProduct;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * The {@code Sale} class represents a sale.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    /**
     * The sale identifier.
     * It's generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The value of the sale.
     */
    @NotNull
    private Double value;

    /**
     * The date the sale was made.
     * Returned in the json that represents the sale in the format 'dd/MM/yyyy'.
     */
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @NotNull
    private Date saleDate;

    /**
     * The list of products sold in the sale.
     */
    @OneToMany(mappedBy = "sale")
    private List<SoldProduct> soldProducts;
}
