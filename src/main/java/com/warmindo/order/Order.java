package com.warmindo.order;

import com.warmindo.model.MenuItem;

import java.util.List;

/**
 * Represents a customer order in the warmindo.
 */
public class Order {
    private final List<MenuItem> items;
    private double totalCost;

    public Order(List<MenuItem> items) {
        this.items = items;
        this.totalCost = 0;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}

