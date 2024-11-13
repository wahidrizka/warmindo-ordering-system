package com.warmindo.model;

/**
 * Represents a food item in the warmindo menu.
 */
public class Food extends MenuItem {
    public Food(String id, String name, double price, int stock) {
        super(id, name, price, stock);
    }
}
