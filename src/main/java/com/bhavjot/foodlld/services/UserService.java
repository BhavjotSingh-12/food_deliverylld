package com.bhavjot.foodlld.services;

import com.bhavjot.foodlld.models.Cart;
import com.bhavjot.foodlld.models.MenuItem;
import com.bhavjot.foodlld.models.Restaurant;
import com.bhavjot.foodlld.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Integer, User> users=new HashMap<>();
    private int useridCounter=1;
    public User createUser(String name, String location){
          int userId=useridCounter++;
          User user=new User(userId,name,location);
          users.put(userId,user);
          return user;
    }

    public User getUser(int userId){
        User user = users.get(userId);
        if(user==null){
            throw new RuntimeException("User Not Found");
        }
        return user;
    }

    public void addItemToCart(int userId, Restaurant restaurant, MenuItem menuItem){
        User user=getUser(userId);
        user.getCart().addItem(restaurant,menuItem);
    }

    public Cart viewCart(int userId){
        return getUser(userId).getCart();
    }

}
