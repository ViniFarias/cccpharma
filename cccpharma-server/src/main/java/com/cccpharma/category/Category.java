package com.cccpharma.category;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The {@code Category} class represents a category.
 *
 * @author Marcus Vinicius
 * @author Jardely Santos
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    /**
     * The category identifier.
     * It's generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * The category name.
     */
    @NotNull
    private String name;

    /**
     * The category discount.
     */
    @NotNull
    private Double discount;
}
