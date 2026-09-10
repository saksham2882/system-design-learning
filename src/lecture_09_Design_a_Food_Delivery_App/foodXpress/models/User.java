package lecture_09_Design_a_Food_Delivery_App.foodXpress.models;

public class User {

    static private int id = 0;
    private final int userId;
    private String name;
    private String address;
    private final Cart cart;

    public User(String name, String address) {
        this.userId = ++id;
        this.name = name;
        this.address = address;
        this.cart = new Cart();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }
}
