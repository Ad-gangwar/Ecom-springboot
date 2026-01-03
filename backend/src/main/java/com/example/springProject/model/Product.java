package com.example.springProject.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private Date releaseDate;
    private int quantity;
    private boolean availability;

    // REQUIRED by JPA
    public Product() {
    }

    public Product(int id, String name, String desc, String brand, BigDecimal price, String category, Date releaseDate, int quantity, boolean availability) {
        this.id = id;
        this.name = name;
        this.desc = desc;   
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.availability = availability;
        this.category = category;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean isAvailability() {
        return availability;
    }
}
