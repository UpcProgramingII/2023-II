package com.mycompany.main.dto;

import com.mycompany.main.model.Product;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProductDto {
    private SimpleIntegerProperty id;
    private SimpleStringProperty description;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty stock;

    /**
     * @return the id
     */
    
    public ProductDto(Product p) {
        
        this.id=new SimpleIntegerProperty(p.getId());
        this.description = new SimpleStringProperty(p.getDescription());
        this.price=new SimpleDoubleProperty(p.getPrice());
        this.stock=new SimpleIntegerProperty(p.getStock());
        
    }

    public int getId() {
        return id.get();
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id.set(id);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description.get();
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description.set(description);
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price.get();
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price.set(price);
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock.get();
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock.set(stock);
    }

     
}
