package com.onlineshop.onlineshop.products.model;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key, auto increment

    private String name;

    @ElementCollection
    private List<String> imageUrl; // Array of string

    private Float price;

    @Column(name = "display_price")
    private Float displayPrice;

    // Constructors
    public Product() {
    }

    public Product(String name, List<String> imageUrl, Float price, Float displayPrice) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.displayPrice = displayPrice;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(Float displayPrice) {
        this.displayPrice = displayPrice;
    }
}
