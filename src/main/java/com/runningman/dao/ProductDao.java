/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runningman.dao;

import com.runningman.entity.Product;
import java.io.InputStream;
import java.util.List;

public interface ProductDao {

    public void insert(Product product, InputStream inputStream);

    public void update(Product product, InputStream inputStream);

    public void delete(long productId);

    public Product findById(long productId);

    public List<Product> findAll(int pageIndex, int pageSize);

    public List<Product> findAllByCategoryId(long categoryId, int pageIndex, int pageSize);
    
    public List<Product> findAllProductByName(String name, int pageIndex, int pageSize);

    public int count();

    public int countByCategoryId(long categoryId);
    
    public int countByProductName(String nameProduct);

    public List<Product> hotProducts(int pageIndex, int pageSize);

    public List<Product> featuredProducts(int pageIndex, int pageSize);

    public List<Product> search(long categoryId, String pricing, double priceFrom, double priceTo, String sort, String text, int pageIndex, int pageSize);

    public int countBySearch(long categoryId, String pricing, double priceFrom, double priceTo, String text);

}
