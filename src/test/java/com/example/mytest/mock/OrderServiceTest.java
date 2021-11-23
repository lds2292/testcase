package com.example.mytest.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.example.mytest.mock.domain.Order;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 * Mockito를 사용해여 Mocking
 */

@Slf4j
class OrderServiceTest {
    private OrderService orderService;

    private List<Order> orderList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        orderList.add(new Order("주문서1", "01011112222"));
        orderList.add(new Order("주문서2", "01033334444"));
    }

    @Test
    void 주문서_조회(){
        //given
        OrderRepository orderRepository = Mockito.mock(OrderRepositoryImpl.class);
        orderService = new OrderService(orderRepository);

        //when
        when(orderRepository.findAll()).then(invocation -> {
            System.out.println("mock Repository");
            return orderList;
        });

        //then
        List<Order> orderList = orderService.getOrders();
        assertEquals(2, orderList.size());
    }

    @Test
    void 주문서_등록시_중복주문서있을때_예외(){
        //given
        Order order = new Order("주문서3", "01044445555");
        OrderRepository orderRepository = Mockito.mock(OrderRepositoryImpl.class);
        orderService = new OrderService(orderRepository);

        //when
        when(orderRepository.findByName(anyString())).then(invocation -> order);

        //then
        assertThrows(OrderDuplicateException.class, ()->{
            orderService.setOrder(order);
        });
    }
}