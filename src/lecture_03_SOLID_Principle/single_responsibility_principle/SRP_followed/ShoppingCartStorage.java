package lecture_03_SOLID_Principle.single_responsibility_principle.SRP_followed;


// 3. ShoppingCartStorage: Only responsible for saving cart to DB
public class ShoppingCartStorage {

    private ShoppingCart shoppingCart;

    public ShoppingCartStorage(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void saveToDatabase(){
        System.out.println("Saving to database...");
    }
}
