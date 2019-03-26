package com.example.lab1.models;


import javax.persistence.*;


public class Product {

    private long id;
    private String name;
    private String description;
    private String imageLink;



    private Category category;
    private Manufacturer manufacturer;

    public Product() {
    }

    public Product(String name, String description, String imageLink, Category category, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.imageLink = imageLink;
        this.category = category;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
