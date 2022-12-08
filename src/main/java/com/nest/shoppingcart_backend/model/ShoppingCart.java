package com.nest.shoppingcart_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingcart")


public class ShoppingCart {

    @Id
    @GeneratedValue

    private int id;

    private String image;
    private String name;
    private String description;
    private String category;
    private String price;

    public ShoppingCart(){}

    public ShoppingCart(int id, String image, String name, String description, String category, String price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
