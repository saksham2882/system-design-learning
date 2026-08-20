package lecture_03_SOLID_Principle.open_close_principle.OCP_followed;

import java.util.List;

// 1. ShoppingCart: Only responsible for Cart related business logic.
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

    // Calculates total price in cart.
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.price;
        }
        return totalPrice;
    }
}
