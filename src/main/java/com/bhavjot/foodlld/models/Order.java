package com.bhavjot.foodlld.models;

import java.util.List;

public class Order {
    private int orderId;
    private List<MenuItem>menuItemList;
    private Restaurant restaurant;
    private User user;
    private double total;

    public Order(int orderId, List<MenuItem> menuItemList, Restaurant restaurant, User user, double total) {
        this.orderId = orderId;
        this.menuItemList = menuItemList;
        this.restaurant = restaurant;
        this.user = user;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotal() {
        return total;
    }
}
