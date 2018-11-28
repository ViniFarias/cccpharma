package com.cccpharma.domain.orm;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private Double discount;
}
