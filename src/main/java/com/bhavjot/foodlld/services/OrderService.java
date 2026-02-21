package com.bhavjot.foodlld.services;

import com.bhavjot.foodlld.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    int orderIdCounter=1;
    Map<Integer, Order> orders=new HashMap<>();

    UserService userService;

    public OrderService(UserService userService) {
        this.userService = userService;
    }

    public Order placeOrder(int userId){
        int orderId=orderIdCounter++;
        User user =userService.getUser(userId);
        Cart cart =user.getCart();
        List<MenuItem> orderItems=new ArrayList<>(cart.getItems());
        double amount=cart.calculateTotal();
        Restaurant restaurant=cart.getRestaurant();
        Order order = new Order(orderId,orderItems,restaurant,user,amount);
        orders.put(orderId,order);
        cart.clear();
        return order;
    }

    public Order getOrder(int orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }
        return order;
    }


}
