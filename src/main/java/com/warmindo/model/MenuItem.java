package com.warmindo.model;

/**
 * Abstract class representing a menu item in the warmindo.
 */
public abstract class MenuItem {
    private final String id;
    private final String name;
    private final double price;
    private int stock;

    public MenuItem(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int amount) {
        if (stock >= amount) {
            stock -= amount;
        }
    }

    @Override
    public String toString() {
        return name + " (Rp" + price + ", Stock: " + stock + ")";
    }
}

