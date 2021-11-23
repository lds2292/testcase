package com.example.mytest.mock;

import com.example.mytest.mock.domain.Order;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private Map<String, Order> orderMap = new HashMap<>();

    @Override
    public List<Order> findAll() {
        return orderMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Order findByName(String name) {
        return orderMap.get(name);
    }

    @Override
    public void save(Order order) {
        orderMap.put(order.getOrderName(), order);
    }
}
