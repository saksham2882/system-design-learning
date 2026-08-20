package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_followed;

import java.util.ArrayList;

public class Main {
    static void main() {

        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());

        shoppingCart.addProduct(new Product("Laptop", 1000));
        shoppingCart.addProduct(new Product("Tablet", 400));

        ShoppingCartPrinter shoppingCartPrinter = new ShoppingCartPrinter(shoppingCart);
        shoppingCartPrinter.printInvoice();

        ShoppingCartStorage shoppingCartStorage = new ShoppingCartStorage(shoppingCart);
        shoppingCartStorage.saveToDatabase();
    }
}
