package lecture_09_Design_a_Food_Delivery_App.foodXpress;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.factories.NowOrderFactory;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.factories.OrderFactory;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.factories.ScheduledOrderFactory;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.managers.OrderManager;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.managers.RestaurantManager;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.*;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.services.NotificationService;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies.PaymentStrategy;

import java.util.List;

public class FoodXpressApp {

    public FoodXpressApp() {
        initializeRestaurant();
    }

    // simulate
    public void initializeRestaurant() {
        Restaurant restaurant1 = new Restaurant("Bikaner", "New Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Samosa", 20));
        restaurant1.addMenuItem(new MenuItem("P2", "Chole Bhature", 145));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Greater Noida");
        restaurant2.addMenuItem(new MenuItem("P1", "Masala Dosa", 140));
        restaurant2.addMenuItem(new MenuItem("P2", "Dhokla", 90));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        // and so on...
    }

    public List<Restaurant> searchRestaurants(String location) {
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant) {
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode){
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant == null){
            System.out.println("Please select a restaurant");
            return;
        }

        for(MenuItem item : restaurant.getMenu()){
            if(item.getCode().equals(itemCode)){
                user.getCart().addItem(item);
                break;
            }
        }
    }

    public Order checkoutNow(User user, String orderType, PaymentStrategy  paymentStrategy) {
        return checkout(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    public Order checkoutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduledTime) {
        return checkout(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduledTime));
    }

    public Order checkout(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        if(user.getCart().isEmpty()){
            System.out.println("Your cart is empty");
            return null;
        }

        Cart userCart = user.getCart();
        Restaurant orderRestaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalPrice = userCart.getTotalPrice();

        Order order = orderFactory.createOrder(user, userCart, orderRestaurant, itemsOrdered, paymentStrategy, totalPrice, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    public void payForOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if(isPaymentSuccess){
            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    public void printUserCart(User user){
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : Rs." + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : Rs." + user.getCart().getTotalPrice());
    }
}
