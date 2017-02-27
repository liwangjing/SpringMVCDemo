package com.jing.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by jing on 2017/2/16.
 */
@Entity
@Table(name = "products")
public class Product implements Serializable {
    private String description;
    private Double price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Product () {

    }
    public Product(Long id, Double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("id: " + getId() + ";");
        buffer.append("Description: " + description + ";");
        buffer.append("Price: " + price + ";");
        return buffer.toString();
    }

}
