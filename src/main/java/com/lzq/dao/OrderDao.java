package com.lzq.dao;

import com.lzq.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    List<Order> selectOrder();
    int orderInsert(Order order);
    int updateOrderStatus(String orderId,String payStatus);
}
