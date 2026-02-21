package com.bhavjot.foodlld.models;

public class MenuItem {
    private int itemId;
    private String itemName;
    private double price;

    public int getItemId() {
        return itemId;
    }

    public MenuItem(int itemId, String itemName, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getItemName() {
        return itemName;
    }
}
