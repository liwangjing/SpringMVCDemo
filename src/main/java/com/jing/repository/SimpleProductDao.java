package com.jing.repository;

import com.jing.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by jing on 2017/2/18.
 * This ProductDao is based on JDBC, and take usage of NamedParameterJdbcTemplate.
 */

@Repository("productDao")
public class SimpleProductDao implements ProductDao {

    protected final Log logger = LogFactory.getLog(getClass());

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate template) {
        this.namedParameterJdbcTemplate = template;
    }

    @Override
    public List<Product> getProducts() {
        logger.info("SimpleProductDao, getProducts()");
        Map<String, Object> params = new HashMap<String, Object>();

        String sql = "SELECT * FROM products";

        List<Product> result = namedParameterJdbcTemplate.query(sql, params, new ProductMapper());

        logger.info("SimpleProductDao, the products are: " + result.toString());
        return result;

    }

    @Override
    public void updateProduct(Product product) {
        logger.info("SimpleProductDao, saveProducts()");
        Long id = product.getId();
        double price = product.getPrice();
        namedParameterJdbcTemplate.update("update products set PRICE = :price where ID = :id"
                , new MapSqlParameterSource("id", id).addValue("price", price));

    }

    @Override
    public void saveProduct(Product product) {

    }

    private static final class ProductMapper implements RowMapper<Product> {

        @Override
        public Product mapRow(ResultSet resultSet, int i) throws SQLException {
            Product product = new Product();
            product.setId(resultSet.getLong("id"));
            product.setDescription(resultSet.getString("description"));
            product.setPrice(resultSet.getDouble("price"));

            return product;
        }
    }
}
