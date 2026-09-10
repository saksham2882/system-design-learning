package lecture_09_Design_a_Food_Delivery_App.foodXpress.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static int id = 0;
    private int restaurantId;
    private String name;
    private String location;
    private final List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name, String location) {
        this.location = location;
        this.name = name;
        this.restaurantId = ++id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void addMenuItem(MenuItem menuItem) {
        menu.add(menuItem);
    }
}
