/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runningman.service.impl;

import com.runningman.dao.ProductCategoryDao;
import com.runningman.entity.ProductCategory;
import com.runningman.model.ProductCategoryDTO;
import com.runningman.service.ProductCategoryService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    private ProductCategoryDao categoryDao;
    
    @Override
    public List<ProductCategoryDTO> findAll() {
        List<ProductCategory> categories = categoryDao.findAll();
        List<ProductCategoryDTO> categoryDTOs = new ArrayList<ProductCategoryDTO>();
        for (ProductCategory category : categories) {
            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
            categoryDTO.setCategoryId(category.getCategoryId());
            categoryDTO.setCategoryName(category.getCategoryName());
            categoryDTOs.add(categoryDTO);
        }
        return categoryDTOs;
    }
    
}
