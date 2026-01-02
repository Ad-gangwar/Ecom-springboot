package com.example.springProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int price;

    // REQUIRED by JPA
    public Product() {
    }

    public Product(int prodId, String prodName, int price) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
    }

    public int getProdId() {
        return prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public int getPrice() {
        return price;
    }
}
