package com.example.mytest.mock;

import com.example.mytest.mock.domain.Order;
import java.util.List;

public interface OrderRepository {
    List<Order> findAll();
    Order findByName(String name);
    void save(Order order);
}
