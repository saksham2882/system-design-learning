package lecture_04_SOLID_Principle.single_responsibility_principle.SRP_followed;

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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}


// 1. ShoppingCart: Only responsible for Cart related business logic.
class ShoppingCart {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    // Calculates total price in cart.
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.price;
        }
        return totalPrice;
    }
}


// 2. ShoppingCartPrinter: Only responsible for printing invoices
class ShoppingCartPrinter {

    private final ShoppingCart shoppingCart;

    public ShoppingCartPrinter(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void printInvoice(){
        System.out.println("Shopping Cart Invoice:\n");
        for(Product product : shoppingCart.getProducts()){
            System.out.println(product);
        }
        System.out.println("Total: $" + shoppingCart.calculateTotalPrice());
    }
}


// 3. ShoppingCartStorage: Only responsible for saving cart to DB
class ShoppingCartStorage {

    private ShoppingCart shoppingCart;

    public ShoppingCartStorage(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void saveToDatabase(){
        System.out.println("Saving to database...");
    }
}


public class SRPFollowed {
    static void main() {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct(new Product("Laptop", 1000));
        shoppingCart.addProduct(new Product("Tablet", 400));

        ShoppingCartPrinter shoppingCartPrinter = new ShoppingCartPrinter(shoppingCart);
        shoppingCartPrinter.printInvoice();

        ShoppingCartStorage shoppingCartStorage = new ShoppingCartStorage(shoppingCart);
        shoppingCartStorage.saveToDatabase();
    }
}
