package com.onlineshop.onlineshop.products.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key, auto increment

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product; // Reference from Product table

    private String name;

    // Constructors
    public Category() {
    }

    public Category(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
