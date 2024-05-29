/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runningman.service.impl;


import com.runningman.dao.SaleDao;
import com.runningman.entity.Sale;
import com.runningman.model.SaleDTO;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author NgocTri
 */

@Service
@Transactional
public class SaleServiceImpl implements com.runningman.service.SaleService{

    @Autowired
	private SaleDao saleDao;
	
    @Override
    public List<SaleDTO> findAll() {
        List<Sale> sales = saleDao.findAll();
		List<SaleDTO> saleDTOs = new ArrayList<>();
		for (Sale sale : sales) {
			SaleDTO saleDTO = new SaleDTO();
			saleDTO.setSaleId(sale.getSaleId());
			saleDTO.setPercent(sale.getPercent());
			saleDTOs.add(saleDTO);
		}
		return saleDTOs;
    }
    
}
