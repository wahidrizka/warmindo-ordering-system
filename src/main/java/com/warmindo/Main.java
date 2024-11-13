package com.warmindo;

import com.warmindo.cli.WarmindoCLI;
import com.warmindo.service.WarmindoService;
import com.warmindo.service.WarmindoServiceImpl;

/**
 * Main class to start the Warmindo Ordering System
 */
public class Main {
    public static void main(String[] args) {
        WarmindoService warmindoService = new WarmindoServiceImpl();
        WarmindoCLI cli = new WarmindoCLI(warmindoService);
        cli.start();
    }
}
