package com.project.restapi.model.entities;

import com.project.restapi.model.entities.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "tb_product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    private ProductStatus productStatus;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(String name, Double price, ProductStatus productStatus, Category category) {
        this.name = name;
        this.price = price;
        this.productStatus = productStatus;
        this.category = category;
    }
}
