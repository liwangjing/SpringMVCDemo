package com.jing.repository;

import com.jing.domain.Product;

import java.util.List;

/**
 * Created by jing on 2017/2/18.
 */
public interface ProductDao {
    public List<Product> getProducts();

    public void updateProduct(Product product);

    public void saveProduct(Product product);
}
