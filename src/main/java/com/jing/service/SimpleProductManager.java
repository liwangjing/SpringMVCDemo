package com.jing.service;

import com.jing.domain.Product;
import com.jing.repository.ProductDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by jing on 2017/2/16.
 */
public class SimpleProductManager implements ProductManager {
    protected final Log logger = LogFactory.getLog(getClass());

    private ProductDao productDao;

    @Override
    public void increasePrice(int percentage) {
        logger.info("SimplrProductManager, increasePrice()");
        List<Product> products = productDao.getProducts();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
                product.setPrice(newPrice);
                productDao.saveProduct(product);
            }
        }
    }

    @Override
    public List<Product> getProducts() {
        logger.info("SimpleProductManager, get products from ProductDao");
        return productDao.getProducts(); // get products list from the database
    }

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }


    /* *
    Code for prepared products in xml.

    private List<Product> products; // for prepared products.

    @Override
    public void increasePrice(int percentage) {
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * (100 + percentage) / 100;
                product.setPrice(newPrice);
            }
        }
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts (List<Product> products) {
        this.products = products;
    }

     */




}
