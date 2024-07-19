package org.example.exo_product.model;

import org.example.exo_product.util.ProductType;

import java.util.UUID;

public class Product {
    private UUID id;
    private String name;
    private ProductType category;
    private double price;

    public Product(UUID id, String name, ProductType category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getCategory() {
        return category;
    }

    public void setCategory(ProductType category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
