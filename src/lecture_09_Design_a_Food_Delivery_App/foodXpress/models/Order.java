package lecture_09_Design_a_Food_Delivery_App.foodXpress.models;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    private static int orderID = 0;

    private final int orderId;
    private User user;
    private Restaurant restaurant;
    private List<MenuItem> items;
    private PaymentStrategy paymentStrategy;
    private double totalPrice;
    private String scheduled;

    public Order() {
        this.orderId = ++orderID;
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.totalPrice = 0.0;
        this.scheduled = "";
    }

    public boolean processPayment() {
        if(paymentStrategy != null) {
            paymentStrategy.pay(totalPrice);
            return true;
        } else {
            System.out.println("Please choose a payment method");
            return false;
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
        totalPrice = 0.0;
        for(MenuItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public abstract String getType();
}
