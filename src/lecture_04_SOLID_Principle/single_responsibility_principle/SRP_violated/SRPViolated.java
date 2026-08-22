package lecture_04_SOLID_Principle.single_responsibility_principle.SRP_violated;

import java.util.ArrayList;
import java.util.List;


// Product class representing any item of any E-Commerce
class Product {
    public String name;
    public double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}


// Violating SRP: ShoppingCart is handling multiple responsibilities
class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    public ShoppingCart() {}

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    // 1. Calculates total price in cart.
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.price;
        }
        return totalPrice;
    }

    // 2. Violating SRP - Prints invoice (Should be in a separate class)
    public  void printInvoice() {
        System.out.println("Shopping Cart Invoice:\n");
        for (Product product : products) {
            System.out.println(product.name + " - $" + product.price);
        }
        System.out.println("Total Price: " + calculateTotalPrice());
    }

    // 3. Violating SRP - Saves to DB (Should be in a separate class)
    public void saveToDatabase(){
        System.out.println("Saving to database...");
    }
}


public class SRPViolated {
    static void main() {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 1000.00));
        cart.addProduct(new Product("Tablet", 400.00));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}
