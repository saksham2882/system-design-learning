package lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies;

public class UPIPaymentStrategy implements PaymentStrategy {

    private final String mobile;

    public UPIPaymentStrategy(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using UPI (" + mobile + ")");
    }
}
