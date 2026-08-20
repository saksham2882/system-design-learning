package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_followed;

// 2. ShoppingCartPrinter: Only responsible for printing invoices
public class ShoppingCartPrinter {

    private ShoppingCart shoppingCart;

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
