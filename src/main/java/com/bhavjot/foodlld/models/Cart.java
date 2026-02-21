package com.bhavjot.foodlld.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public User user;
    public Restaurant restaurant;
    public List<MenuItem> items;

    public Cart(User user) {
        this.user = user;
        this.items=new ArrayList<>();
    }

    public void addItem(Restaurant restaurant, MenuItem menuItem) {
        if (this.restaurant == null) {
            this.restaurant = restaurant;
        }
        if (!this.restaurant.equals(restaurant)) {
            throw new IllegalStateException("cannot add another's restaurant item");
        }

        items.add(menuItem);
    }

    public List<MenuItem> getItems(){
        return items;
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void clear() {
        this.restaurant=null;
        items.clear();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "user=" + user +
                ", restaurant=" + restaurant +
                ", items=" + items +
                '}';
    }
}
