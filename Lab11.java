// Product.java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

// Main.java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 85000));
        products.add(new Product("Smartphone", 35000));
        products.add(new Product("Headphones", 3000));
        products.add(new Product("Smartwatch", 12000));
        products.add(new Product("Laptop", 75000));

        System.out.println("Original List:");
        products.forEach(System.out::println);

        // 🔹 Sort by price (ascending)
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        // 🔹 Sort by name (alphabetical)
        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
        System.out.println("\nSorted by Name:");
        products.forEach(System.out::println);

        // 🔹 Sort by name, then by price
        products.sort((p1, p2) -> {
            int nameCompare = p1.getName().compareToIgnoreCase(p2.getName());
            if (nameCompare != 0) return nameCompare;
            return Double.compare(p1.getPrice(), p2.getPrice());
        });
        System.out.println("\nSorted by Name then Price:");
        products.forEach(System.out::println);
    }
}

