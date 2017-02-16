package com.jing.service;

import com.jing.domain.Product;

import java.util.List;

/**
 * Created by jing on 2017/2/16.
 */
public class SimpleProductManager implements ProductManager {
    private List<Product> products;

    @Override
    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
                product.setPrice(newPrice);
            }
        }
//        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> getProducts() {
        return products;
//        throw new UnsupportedOperationException();
    }

    public void setProducts (List<Product> products) {
//        throw new UnsupportedOperationException();
        this.products = products;
    }
}
