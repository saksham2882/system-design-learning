package lecture_09_Design_a_Food_Delivery_App.foodXpress.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private Restaurant restaurant;
    private final List<MenuItem> items = new ArrayList<>();

    public Cart() {
        restaurant = null;
    }

    public void addItem(MenuItem item) {
        if(restaurant == null) {
            System.err.println("Cart: Set a restaurant before adding items.");
            return;
        }
        items.add(item);
    }

    public double getTotalPrice() {
        double sum = 0;
        for(MenuItem item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public boolean isEmpty() {
        return restaurant == null || items.isEmpty();
    }

    public void clear() {
        items.clear();
        restaurant = null;
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
}
