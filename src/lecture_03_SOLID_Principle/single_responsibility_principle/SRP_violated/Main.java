package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_violated;

import java.util.ArrayList;

public class Main {
    static void main() {

        ShoppingCart cart = new ShoppingCart(new ArrayList<>());

        cart.addProduct(new Product("Laptop", 1000.00));
        cart.addProduct(new Product("Tablet", 400.00));

        cart.printInvoice();
        cart.saveToDatabase();
    }
}
