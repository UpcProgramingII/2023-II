package com.mycompany.main.model;

public class Product {
    private static int ID_PRODUCTS=100;
    private int id;
    private String description;
    private double price;
    private int stock;

    public Product(String description, double price, int stock) {
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.id=Product.ID_PRODUCTS;
        Product.ID_PRODUCTS++;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", description=" + description + ", price=" + price + ", stock=" + stock + '}';
    }
    
    
    
}
