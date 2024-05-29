package com.runningman.service;

import com.runningman.entity.Product;
import com.runningman.model.ProductDTO;
import java.io.InputStream;
import java.util.List;

public interface ProductService {

    public void insert(Product product, InputStream inputStream);

    public void update(ProductDTO productDTO, InputStream inputStream);

    public void delete(long productId);

    public List<ProductDTO> hotProducts(int pageIndex, int pageSize);

    public List<ProductDTO> featuredProducts(int pageIndex, int pageSize);

    public ProductDTO findById(long productId);

    public List<ProductDTO> findAll(int pageIndex, int pageSize);

    public List<ProductDTO> findAllByCategoryId(long categoryId, int pageIndex, int pagesize);

    public List<ProductDTO> search(long categoryId, String pricing, double priceFrom, double priceTo, String sort, String text, int pageIndex, int pageSize);

    public List<ProductDTO> findAllProductByName(String name, int pageIndex, int pageSize);
    
    public int count();

    public int countByCategoryId(long categoryId);
    
    public int countByProductName(String name);

    public int countBySearch(long categoryId, String pricing, double priceFrom, double priceTo, String text);

}
