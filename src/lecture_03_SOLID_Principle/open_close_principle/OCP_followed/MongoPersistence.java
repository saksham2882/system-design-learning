package lecture_03_SOLID_Principle.open_close_principle.OCP_followed;

// 3. MongoPersistence: Only responsible for saving cart to Mongo DB
public class MongoPersistence implements Persistence {

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving shopping cart to Mongo Database...");
    }
}
