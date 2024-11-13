package com.warmindo.cli;

import com.warmindo.model.Drink;
import com.warmindo.model.Food;
import com.warmindo.model.MenuItem;
import com.warmindo.order.Order;
import com.warmindo.service.WarmindoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Command-line interface for the Warmindo system.
 */
public class WarmindoCLI {
    private final WarmindoService warmindoService;
    private final Scanner scanner = new Scanner(System.in);

    public WarmindoCLI(WarmindoService warmindoService) {
        this.warmindoService = warmindoService;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nWarmindo Ordering System");
            System.out.println("1. Add Menu Item");
            System.out.println("2. Remove Menu Item");
            System.out.println("3. List Menu Items");
            System.out.println("4. Place Order");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> addMenuItem();
                case 2 -> removeMenuItem();
                case 3 -> listMenuItems();
                case 4 -> placeOrder();
                case 0 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addMenuItem() {
        System.out.println("Enter item type (food/drink): ");
        String type = scanner.nextLine();
        System.out.println("Enter item ID: ");
        String id = scanner.nextLine();
        System.out.println("Enter item name: ");
        String name = scanner.nextLine();
        System.out.println("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter item stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // consume newline

        MenuItem item;
        if (type.equalsIgnoreCase("food")) {
            item = new Food(id, name, price, stock);
        } else {
            item = new Drink(id, name, price, stock);
        }
        warmindoService.addItem(item);
    }

    private void removeMenuItem() {
        System.out.print("Enter item ID to remove: ");
        String itemId = scanner.nextLine();
        warmindoService.removeItem(itemId);
    }

    private void listMenuItems() {
        warmindoService.listItems().forEach(System.out::println);
    }

    private void placeOrder() {
        List<MenuItem> items = new ArrayList<>();
        System.out.print("Enter the number of items in order: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter item ID: ");
            String itemId = scanner.nextLine();
            warmindoService.listItems().stream()
                    .filter(item -> item.getId().equals(itemId))
                    .findFirst()
                    .ifPresent(items::add);
        }

        Order order = new Order(items);
        warmindoService.placeOrder(order);
        warmindoService.printReceipt(order);
    }
}
