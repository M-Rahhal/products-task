package com.task.Products_App.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;


    @Column(
            name = "price",
            precision = 10,
            scale = 2
    )
    private BigDecimal price;
}
