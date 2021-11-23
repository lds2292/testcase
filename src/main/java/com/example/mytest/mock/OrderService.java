package com.example.mytest.mock;

import com.example.mytest.mock.domain.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepositoryImpl;

    public OrderService(OrderRepository orderRepositoryImpl) {
        this.orderRepositoryImpl = orderRepositoryImpl;
    }

    public List<Order> getOrders(){
        return orderRepositoryImpl.findAll();
    }

    public Order getOrder(String name){
        return orderRepositoryImpl.findByName(name);
    }

    public void setOrder(Order order) throws OrderDuplicateException{
        Order findOrder = orderRepositoryImpl.findByName(order.getOrderName());
        if( findOrder != null)
            throw new OrderDuplicateException("중복된 주문이 있습니다");
        orderRepositoryImpl.save(order);
    }

}
