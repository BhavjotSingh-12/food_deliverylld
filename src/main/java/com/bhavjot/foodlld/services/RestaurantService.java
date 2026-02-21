package com.bhavjot.foodlld.services;

import com.bhavjot.foodlld.models.MenuItem;
import com.bhavjot.foodlld.models.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RestaurantService {
    public Map<Integer, Restaurant> restaurants = new HashMap<>();
    public int restaurantCounter = 1;
    public int menuItemCounter = 1;

    public Restaurant addRestaurant(String name, String location) {
        int restaurantId = restaurantCounter++;
        Restaurant restaurant = new Restaurant(restaurantId, name, location);
        restaurants.put(restaurantId, restaurant);
        return restaurant;
    }

    public Restaurant getRestaurantById(int restaurantId) {
        Restaurant restaurant = restaurants.get(restaurantId);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant Not Found");
        }
        return restaurant;
    }

    public List<Restaurant> getRestaurantByLocation(String location) {
        return restaurants.values()
                .stream()
                .filter(restaurant -> restaurant.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    public void addMenuItems(int restaurantId, String itemName, double price) {
        Restaurant restaurant = getRestaurantById(restaurantId);
        int itemId = menuItemCounter++;
        MenuItem item = new MenuItem(itemId, itemName, price);
        restaurant.addMenuItem(item);
    }
}
