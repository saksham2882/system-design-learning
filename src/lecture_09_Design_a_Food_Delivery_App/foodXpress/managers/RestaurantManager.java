package lecture_09_Design_a_Food_Delivery_App.foodXpress.managers;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.Restaurant;

import java.util.ArrayList;
import java.util.List;

// Singleton
public class RestaurantManager {

    private final List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    public RestaurantManager() {
    }

    // Not considering multi-threading
    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> searchByLocation(String location) {
        List<Restaurant> results = new ArrayList<>();
        location = location.toLowerCase();

        for (Restaurant restaurant : restaurants) {
            String restaurantLocation = restaurant.getLocation().toLowerCase();
            if (restaurantLocation.contains(location)) {
                results.add(restaurant);
            }
        }
        return results;
    }
}
