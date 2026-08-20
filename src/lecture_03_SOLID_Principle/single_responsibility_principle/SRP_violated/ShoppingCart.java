package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_violated;

import java.util.List;


// Violating SRP: ShoppingCart is handling multiple responsibilities
public class ShoppingCart {

    private final List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

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