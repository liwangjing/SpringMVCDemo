package com.jing.service;

import com.jing.domain.Product;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jing on 2017/2/16.
 */
public interface ProductManager extends Serializable {
    public void increasePrice(int percentage);
    public List<Product> getProducts();
    public void updateProduct(Product product);
    public void saveProduct(Product product);
}
