import java.util.ArrayList;
import java.util.List;

class Product {

    private String name;
    private int stockQuantity;
    private double price;

    Product(String name, int stockQuantity, double price) {
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20s | Stock: %-5d | Price: Rs. %.2f", name, stockQuantity, price);
    }
}


class InventoryManager {

    private List<Product> products;
    private int lowStockThreshold;

    InventoryManager(int lowStockThreshold) {
        this.products = new ArrayList<>();
        this.lowStockThreshold = lowStockThreshold;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayInventory() {
        System.out.println("\n========================================");
        System.out.println("         INVENTORY STATUS REPORT        ");
        System.out.println("========================================");

        if (products.isEmpty()) {
            System.out.println("  No products found in inventory.");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + products.get(i));
        }

        System.out.println("========================================");
        System.out.println("  Total Products: " + products.size());
        System.out.println("========================================\n");
    }

    public void checkLowStock() {
        System.out.println("----------------------------------------");
        System.out.println("      LOW STOCK ALERTS (Limit: " + lowStockThreshold + ")      ");
        System.out.println("----------------------------------------");

        boolean anyAlert = false;

        for (Product product : products) {
            if (product.getStockQuantity() < lowStockThreshold) {
                System.out.println("  ⚠  " + product.getName()
                        + " — only " + product.getStockQuantity() + " units left!");
                anyAlert = true;
            }
        }

        if (!anyAlert) {
            System.out.println("  All products are sufficiently stocked.");
        }

        System.out.println("----------------------------------------\n");
    }

    public void updateStock(String productName, int newQuantity) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                product.setStockQuantity(newQuantity);
                System.out.println("  Updated: " + productName + " → new stock = " + newQuantity);
                return;
            }
        }
        System.out.println("  Product not found: " + productName);
    }

    public int getTotalStock() {
        int total = 0;
        for (Product product : products) {
            total += product.getStockQuantity();
        }
        return total;
    }
}


public class InventorySystem {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager(10);

        manager.addProduct(new Product("Wireless Mouse",      45,  799.00));
        manager.addProduct(new Product("Mechanical Keyboard", 8,   2499.00));
        manager.addProduct(new Product("USB-C Hub",           3,   1299.00));
        manager.addProduct(new Product("Laptop Stand",        22,  1099.00));
        manager.addProduct(new Product("Webcam HD",           7,   3499.00));
        manager.addProduct(new Product("Desk Lamp",           0,   599.00));
        manager.addProduct(new Product("Monitor Arm",         15,  1899.00));
        manager.addProduct(new Product("HDMI Cable",          60,  299.00));

        manager.displayInventory();

        manager.checkLowStock();

        System.out.println("  Restocking USB-C Hub...");
        manager.updateStock("USB-C Hub", 25);

        System.out.println("  Restocking Desk Lamp...");
        manager.updateStock("Desk Lamp", 12);

        System.out.println();
        manager.displayInventory();

        manager.checkLowStock();

        System.out.println("  Total units across all products: " + manager.getTotalStock());
    }
}