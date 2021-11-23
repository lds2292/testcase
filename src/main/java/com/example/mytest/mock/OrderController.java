package com.example.mytest.mock;

import com.example.mytest.mock.domain.Order;
import java.util.List;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/{name}")
    public Order getOrder(@PathVariable String name) {
        return orderService.getOrder(name);
    }

    @PostMapping
    public void setOrder(Order order){
        orderService.setOrder(order);
    }

    @ExceptionHandler(OrderDuplicateException.class)
    private String exceptionHandler(OrderDuplicateException ode){
        ode.printStackTrace();
        return ode.getMessage();
    }

}
