package lecture_03_SOLID_Principle.open_close_principle.OCP_violated;


// 3. ShoppingCartStorage: Only responsible for saving cart to DB
public class ShoppingCartStorage {

    private ShoppingCart shoppingCart;

    public ShoppingCartStorage(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void saveToSQLDatabase(){
        System.out.println("Saving shopping cart to SQL database...");
    }

    // ============= Add this (later) to show violation of open-close principle ==============
    public void saveToMongoDatabase(){
        System.out.println("Saving shopping cart to Mongo database...");
    }

    // ============= Add this (later) to show violation of open-close principle ==============
    public void saveToFile(){
        System.out.println("Saving shopping cart to File...");
    }
}
