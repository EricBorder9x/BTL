/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runningman.dao;

import com.runningman.entity.OrderDetail;
import java.util.List;

public interface OrderDetailDao {

    void insert(OrderDetail orderDetail);

    void update(OrderDetail orderDetail);

    void delete(long orderDetailId);

    List<OrderDetail> findAll(int pageIndex, int pageSize);

    List<OrderDetail> findByOrderId(long orderId);
}
