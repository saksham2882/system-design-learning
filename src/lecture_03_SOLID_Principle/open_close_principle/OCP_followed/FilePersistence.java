package lecture_03_SOLID_Principle.open_close_principle.OCP_followed;

// 3. FilePersistence: Only responsible for saving cart to File
public class FilePersistence implements Persistence {

    @Override
    public void save(ShoppingCart shoppingCart) {
        System.out.println("Saving shopping cart to File...");
    }
}
