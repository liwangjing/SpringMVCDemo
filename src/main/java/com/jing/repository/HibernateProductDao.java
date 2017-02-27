package com.jing.repository;

import com.jing.domain.Product;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jing on 2017/2/27.
 */
@Transactional
@Repository("hibernateDao")
public class HibernateProductDao implements ProductDao {

    private SessionFactory sessionFactory;

    public HibernateProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Integer count() {
        return getProducts().size();
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) currentSession().createCriteria(Product.class).list();
    }

    @Override
    public void updateProduct(Product product) {
        currentSession().update(product);
    }

    @Override
    public void saveProduct(Product product) {
        Serializable id = currentSession().save(product);
    }

    public Product findById (Long id) {
        return (Product)currentSession().get(Product.class, id);
    }

    public Product findByDescription (String description) {
        return (Product) currentSession().createCriteria(Product.class).add(Restrictions.eq("Description", description)).list().get(0);
    }

    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}
