# Inventory Tracking System — Java

A console-based inventory management program built in Java, demonstrating core OOP concepts including encapsulation, class design, constructors with `this`, getters/setters, and loop-based iteration.

---

## Features

- Add products with name, stock quantity, and price
- Display full inventory in a formatted table
- Detect low-stock items and print ⚠ alerts automatically
- Update stock for any product by name
- Calculate total stock count across all products

---

## OOP Concepts Used

| Concept | Where Applied |
|---|---|
| Encapsulation | All `Product` fields are `private` |
| `this` keyword | Used in constructors to resolve name conflicts |
| Getters | `getName()`, `getStockQuantity()`, `getPrice()` |
| Setters | `setStockQuantity()`, `setPrice()` |
| `toString()` override | Custom print format for `Product` |
| Index-based loop | `displayInventory()` — numbered listing |
| Enhanced for-loop | `checkLowStock()`, `updateStock()`, `getTotalStock()` |

---

## Project Structure

```
InventorySystem.java
│
├── class Product
│   ├── Fields: name, stockQuantity, price  (all private)
│   ├── Constructor (uses this keyword)
│   ├── Getters: getName(), getStockQuantity(), getPrice()
│   ├── Setters: setStockQuantity(), setPrice()
│   └── toString(): formatted output
│
├── class InventoryManager
│   ├── Fields: List<Product> products, int lowStockThreshold
│   ├── addProduct(Product)
│   ├── displayInventory()
│   ├── checkLowStock()
│   ├── updateStock(String, int)
│   └── getTotalStock()
│
└── public class InventorySystem
    └── main() — program entry point
```

---

## How to Run

**Requirements:** Java JDK 8 or above

```bash
# Step 1 — Compile
javac InventorySystem.java

# Step 2 — Run
java InventorySystem
```

---

## Sample Output

```
========================================
         INVENTORY STATUS REPORT        
========================================
  1. Wireless Mouse        | Stock: 45    | Price: Rs. 799.00
  2. Mechanical Keyboard   | Stock: 8     | Price: Rs. 2499.00
  3. USB-C Hub             | Stock: 3     | Price: Rs. 1299.00
  4. Laptop Stand          | Stock: 22    | Price: Rs. 1099.00
  5. Webcam HD             | Stock: 7     | Price: Rs. 3499.00
  6. Desk Lamp             | Stock: 0     | Price: Rs. 599.00
  7. Monitor Arm           | Stock: 15    | Price: Rs. 1899.00
  8. HDMI Cable            | Stock: 60    | Price: Rs. 299.00
========================================
  Total Products: 8
========================================

----------------------------------------
      LOW STOCK ALERTS (Limit: 10)      
----------------------------------------
  ⚠  Mechanical Keyboard — only 8 units left!
  ⚠  USB-C Hub — only 3 units left!
  ⚠  Webcam HD — only 7 units left!
  ⚠  Desk Lamp — only 0 units left!
----------------------------------------
```

---

## Customization

**Low stock limit change karna ho** — `main()` mein `InventoryManager` ka argument badlo:

```java
// Default 10 hai, aap koi bhi number de sakte ho
InventoryManager manager = new InventoryManager(15);
```

**Naya product add karna ho:**

```java
manager.addProduct(new Product("Product Name", quantity, price));
```

**Kisi product ka stock update karna ho:**

```java
manager.updateStock("Product Name", newQuantity);
```

---

## File Info

| Detail | Value |
|---|---|
| Language | Java |
| File | `InventorySystem.java` |
| Classes | `Product`, `InventoryManager`, `InventorySystem` |
| External Libraries | None (only `java.util`) |
| JDK Required | 8+ |

Output:

