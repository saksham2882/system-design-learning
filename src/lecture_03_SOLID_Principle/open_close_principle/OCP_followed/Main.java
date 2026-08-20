package lecture_03_SOLID_Principle.open_close_principle.OCP_followed;

import java.util.ArrayList;

public class Main {
    static void main() {

        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());

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
