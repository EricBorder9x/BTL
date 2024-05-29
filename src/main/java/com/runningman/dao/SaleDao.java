package com.runningman.dao;

import java.util.List;

import com.runningman.entity.Sale;

public interface SaleDao {

    List<Sale> findAll();
}
