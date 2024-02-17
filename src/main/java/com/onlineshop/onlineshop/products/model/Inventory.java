package com.onlineshop.onlineshop.products.model;

import jakarta.persistence.*;


@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key, auto increment

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product; // Referencing the id from the product table

    private int quantity;

    @Column(name = "is_empty")
    private boolean isEmpty;

    // Constructors
    public Inventory() {
    }

    public Inventory(Product product, int quantity, boolean isEmpty) {
        this.product = product;
        this.quantity = quantity;
        this.isEmpty = isEmpty;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
