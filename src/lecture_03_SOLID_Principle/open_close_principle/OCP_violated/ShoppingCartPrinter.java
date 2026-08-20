package lecture_03_SOLID_Principle.open_close_principle.OCP_violated;

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
