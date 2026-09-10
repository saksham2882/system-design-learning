package lecture_09_Design_a_Food_Delivery_App.foodXpress.models;

public class DeliveryOrder extends Order {

    private String userAddress;

    public DeliveryOrder() {
        this.userAddress = "";
    }

    @Override
    public String getType(){
        return "Delivery";
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
