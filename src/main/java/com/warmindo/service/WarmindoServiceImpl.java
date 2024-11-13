package com.warmindo.service;

import com.warmindo.model.MenuItem;
import com.warmindo.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of WarmindoService for managing menu items and orders.
 */
public class WarmindoServiceImpl implements WarmindoService {
    private final List<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void addItem(MenuItem item) {
        menuItems.add(item);
        System.out.println("Item added: " + item);
    }

    @Override
    public void removeItem(String itemId) {
        menuItems.removeIf(item -> item.getId().equals(itemId));
        System.out.println("Item removed: " + itemId);
    }

    @Override
    public List<MenuItem> listItems() {
        return menuItems;
    }

    @Override
    public void placeOrder(Order order) {
        double total = 0;
        for (MenuItem item : order.getItems()) {
            if (item.getStock() > 0) {
                item.reduceStock(1);
                total += item.getPrice();
            } else {
                System.out.println("Item out of stock: " + item.getName());
            }
        }
        order.setTotalCost(total);
        System.out.println("Order placed with total cost: " + total);
    }

    @Override
    public void printReceipt(Order order) {
        System.out.println("Receipt:");
        order.getItems().forEach(item ->
                System.out.println(item.getName() + " - Rp" + item.getPrice()));
        System.out.println("Total: Rp" + order.getTotalCost());
    }
}
