package lecture_04_SOLID_Principle.open_close_principle.OCP_followed;

import java.util.ArrayList;
import java.util.List;


// Product class representing any item in E-Commerce.
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
                ", price=$" + price +
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


interface Persistence {
    // abstract method
    public void save(ShoppingCart shoppingCart);
}


// 3. SQLPersistence: Only responsible for saving cart to SQL DB
class SQLPersistence implements Persistence {

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving ShoppingCart to SQL Database...");
    }
}


// 3. MongoPersistence: Only responsible for saving cart to Mongo DB
class MongoPersistence implements Persistence {

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving shopping cart to Mongo Database...");
    }
}


// 3. FilePersistence: Only responsible for saving cart to File
class FilePersistence implements Persistence {

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving shopping cart to File...");
    }
}



public class OCPFollowed {
    static void main() {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addProduct(new Product("Laptop", 1000));
        shoppingCart.addProduct(new Product("Tablet", 400));
        shoppingCart.addProduct(new Product("mouse", 100));
        shoppingCart.addProduct(new Product("cable", 50));

        ShoppingCartPrinter shoppingCartPrinter = new ShoppingCartPrinter(shoppingCart);
        shoppingCartPrinter.printInvoice();

        Persistence sqlDB = new SQLPersistence();
        Persistence mongoDB = new MongoPersistence();
        Persistence file = new FilePersistence();

        sqlDB.save(shoppingCart);
        mongoDB.save(shoppingCart);
        file.save(shoppingCart);
    }
}
