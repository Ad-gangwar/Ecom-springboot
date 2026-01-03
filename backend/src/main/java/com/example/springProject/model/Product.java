package com.example.springProject.model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

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
    private int stockQuantity;
    private boolean availability;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;

    // REQUIRED by JPA
    public Product() {
    }

    public Product(int id, String name, String desc, String brand, BigDecimal price, String category, Date releaseDate, int stockQuantity, boolean availability) {
        this.id = id;
        this.name = name;
        this.desc = desc;   
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.availability = availability;
        this.category = category;
        this.releaseDate = releaseDate;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
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
    public int getStockQuantity() {
        return stockQuantity;
    }
    public boolean isAvailability() {
        return availability;
    }
    public String getImageName() {
        return imageName;
    }
    public String getImageType() {
        return imageType;
    }
    public byte[] getImageData() {
        return imageData;
    }
}
