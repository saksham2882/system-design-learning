package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_followed;

import java.util.List;

// 1. ShoppingCart: Only responsible for Cart related business logic.
public class ShoppingCart {

    private List<Product> products;             // store heap-allocated products

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
