# Warmindo Ordering System 🍳
A simple Indonesian restaurant system focused on serving instant noodles and beverages. The system will allow a warmindo (Warung Indomie) to manage a menu, accept customer orders, track available items, and generate a receipt.

### The system requirements:
1. **Manage Menu**: Add and remove items (food and drink) on the menu, list available items.
2. **Place Order**: Accept customer orders, calculate the total cost, and print a receipt.
3. **Manage Stock**: Track item availability based on stock.
4. **Follow S.O.L.I.D Principles**: Apply Object-Oriented Design using S.O.L.I.D. principles.
5. **Command Line Interface (CLI)**: Enable customers to interact with the system through the CLI.

### Structure
The project is divided into:
1. ``WarmindoService`` - main interface for menu and order management.
2. ``MenuItem`` (abstract) - base class representing an item on the menu (either ``Food`` or ``Drink``).
3. ``Order`` - entity representing a customer order.
4. ``WarmindoCLI`` - command-line interface for user interaction.
5. ``Main`` - the entry point for the application.

Each class will be on its own file, witten with Java standards.