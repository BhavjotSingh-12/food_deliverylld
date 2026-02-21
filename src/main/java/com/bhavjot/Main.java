package com.bhavjot;

import com.bhavjot.foodlld.models.*;
import com.bhavjot.foodlld.services.OrderService;
import com.bhavjot.foodlld.services.RestaurantService;
import com.bhavjot.foodlld.services.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        UserService userService = new UserService();
        OrderService orderService = new OrderService(userService);


        Restaurant restaurant1 = restaurantService.addRestaurant("Domino's", "pitampura");
        Restaurant restaurant2 = restaurantService.addRestaurant("MC Donald's", "rohini");

        restaurantService
                .getRestaurantByLocation("pitampura")
                .forEach(r -> System.out.println(r.getRestaurantName() + " - " + r.getLocation()));

        restaurantService.addMenuItems(restaurant1.getRestaurantId(), "farm house", 400);
        restaurantService.addMenuItems(restaurant1.getRestaurantId(), "Loaded", 350);

        User user = userService.createUser("Bhavjot", "Delhi");

        MenuItem farmHouse = restaurant1.getItemById(1);
        MenuItem loaded = restaurant1.getItemById(2);

        userService.addItemToCart(user.getUserId(), restaurant1, farmHouse);
        userService.addItemToCart(user.getUserId(), restaurant1, loaded);

        Cart cart = user.getCart();

        System.out.println("Restaurant: " + cart.getRestaurant().getRestaurantId());
        System.out.println("Items: ");
        cart.getItems().forEach(item ->
                System.out.println(item.getItemId() + " - " + item.getItemName() + " - " + item.getPrice())
        );
        System.out.println("Total: " + cart.calculateTotal());
        System.out.println("Cart Total:" + cart.calculateTotal());

        Order order = orderService.placeOrder(user.getUserId());

        System.out.println("Order placed successfully");
        System.out.println("Order Id: " + order.getOrderId());
        System.out.println("Restaurant: " + restaurant1.getRestaurantName() + " " + restaurant1.getLocation());
        System.out.println("Total: " + order.getTotal());

    }

}