package com.example.mytest.mock.domain;

public class Order {
    private String orderName;
    private String telNumber;

    public Order() {
    }

    public Order(String orderName, String telNumber) {
        this.orderName = orderName;
        this.telNumber = telNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
