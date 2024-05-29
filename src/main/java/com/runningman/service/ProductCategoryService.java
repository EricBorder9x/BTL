package com.runningman.service;

import com.runningman.model.ProductCategoryDTO;
import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategoryDTO> findAll();
}
