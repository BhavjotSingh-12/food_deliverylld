package com.bhavjot.foodlld.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menuItems;

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName(){
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Restaurant(int restaurantId, String name, String location) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.menuItems = new ArrayList<>();
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public MenuItem getItemById(int itemId) {
        return menuItems.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElseThrow(()->new RuntimeException("Item Not found"));
    }
}
