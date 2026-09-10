package lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies;

public class CreditCardPaymentStrategy implements PaymentStrategy {

    private final String cardNumber;

    public CreditCardPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs." + amount + " using Credit Card (" + cardNumber + ")");
    }
}
