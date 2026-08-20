package lecture_03_SOLID_Principle.open_close_principle.OCP_followed;

// 3. SQLPersistence: Only responsible for saving cart to SQL DB
public class SQLPersistence implements Persistence {

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving ShoppingCart to SQL Database...");
    }
}
