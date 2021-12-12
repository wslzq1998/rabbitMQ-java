package com.lzq.service;

import com.lzq.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> selectOrder();
    int orderInsert(Order order);
    int updateOrderStatus(String orderId,String payStatus);
}
