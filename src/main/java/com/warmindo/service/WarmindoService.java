package com.warmindo.service;

import com.warmindo.model.MenuItem;
import com.warmindo.order.Order;

import java.util.List;

public interface WarmindoService {
    void addItem(MenuItem item);
    void removeItem(String itemId);
    List<MenuItem> listItems();
    void placeOrder(Order order);
    void printReceipt(Order order);
}

