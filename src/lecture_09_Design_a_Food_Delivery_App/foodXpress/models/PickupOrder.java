package lecture_09_Design_a_Food_Delivery_App.foodXpress.models;

public class PickupOrder extends Order {

    private String restaurantAddress;

    public PickupOrder() {
        restaurantAddress = "";
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    @Override
    public String getType() {
        return "PickupOrder";
    }
}
