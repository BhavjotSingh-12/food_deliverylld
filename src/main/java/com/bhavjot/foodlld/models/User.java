package com.bhavjot.foodlld.models;

public class User {
    private int userId;
    private String userName;
    private String location;
    private Cart cart;

    public User(int userId, String userName, String location) {
        this.userId = userId;
        this.userName = userName;
        this.location = location;
        this.cart=new Cart(this);
    }

    public Cart getCart() {
        return cart;
    }

    public int getUserId() {
        return userId;
    }
}
