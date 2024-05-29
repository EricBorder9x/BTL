package com.runningman.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.runningman.dao.ProductCategoryDao;
import com.runningman.entity.ProductCategory;

@Repository
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ProductCategory> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductCategory.class);
        return criteria.list();
    }

}
