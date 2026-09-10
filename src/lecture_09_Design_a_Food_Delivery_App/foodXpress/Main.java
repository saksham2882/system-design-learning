package lecture_09_Design_a_Food_Delivery_App.foodXpress;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.Order;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.Restaurant;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.User;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies.UPIPaymentStrategy;

import java.util.List;

public class Main {
    static void main() {

        // Simulating complete flow
        // Create FoodXpress Object
        FoodXpressApp app = new FoodXpressApp();

        // Simulate a user
        User user = new User("Rahul", "New Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        // User searches for restaurant by location
        List<Restaurant> restaurantList = app.searchRestaurants("New Delhi");
        if(restaurantList.isEmpty()){
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Restaurants found!");
        for(Restaurant restaurant : restaurantList){
            System.out.println("Restaurant name: " + restaurant.getName());
        }

        // User selects a restaurant
        app.selectRestaurant(user, restaurantList.getFirst());
        System.out.println("Selected restaurant name: " + restaurantList.getFirst().getName());

        // User adds items to the cart
        app.addToCart(user, "P1");
        app.addToCart(user, "P2");

        // Print user cart
        app.printUserCart(user);

        // User checkout the cart
        Order order = app.checkoutNow(user, "delivery", new UPIPaymentStrategy("8765432109"));

        // User pays for the cart. If payment is successful, notification is sent.
        app.payForOrder(user, order);
    }
}
