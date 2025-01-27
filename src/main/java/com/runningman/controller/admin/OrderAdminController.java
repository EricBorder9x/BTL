/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.runningman.controller.admin;

import com.runningman.model.OrderDTO;
import com.runningman.service.OrderDetailService;
import com.runningman.service.OrderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author NgocTri
 */
@Controller
@RequestMapping(value = "/admin")
public class OrderAdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping(value = "/order-list")
    public String findAll(HttpServletRequest request, HttpSession session) {
        int pageIndex = 0;
        int pageSize = 10;
        int totalPage = 0;
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        int count = orderService.count();
        if (count % 10 == 0) {
            totalPage = count / pageSize;
        } else {
            totalPage = count / pageSize + 1;
        }
        
        double sumRevenue = orderService.sumRevenue();
        session.setAttribute("revenue", sumRevenue);
        session.setAttribute("countOrder", count);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("orders", orderService.findAll(pageIndex, pageSize));
        return "admin/order/order_list";
    }

    @GetMapping(value = "order-details")
    public String orderDetails(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter("orderId"));
        request.setAttribute("orderDetails", orderDetailService.findByOrderId(orderId));
        request.setAttribute("order", orderService.findById(orderId));
        return "admin/order/order_details";
    }

    @GetMapping(value = "order-updateHome")
    public String orderUpdateHome(HttpServletRequest request) {
        long orderId = Long.parseLong(request.getParameter("orderId"));
        OrderDTO orderDTO = orderService.findById(orderId);
        orderDTO.setStatus("Đã duyệt");
        orderService.update(orderDTO);
        return "redirect:/admin/home";
    }

    @GetMapping(value = "order-update")
    public String orderUpdate(HttpServletRequest request) {
        int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        long orderId = Long.parseLong(request.getParameter("orderId"));
        OrderDTO orderDTO = orderService.findById(orderId);
        orderDTO.setStatus("Đã duyệt");
        orderService.update(orderDTO);
        return "redirect:../admin/order-list?pageIndex=" + pageIndex;
    }

}
