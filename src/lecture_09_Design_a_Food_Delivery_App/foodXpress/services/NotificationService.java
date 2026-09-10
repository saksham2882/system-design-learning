package lecture_09_Design_a_Food_Delivery_App.foodXpress.services;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.MenuItem;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.Order;

import java.util.List;

public class NotificationService {

    public static void notify(Order order) {
        System.out.println("\nNotification: New " + order.getType() + " order placed!");
        System.out.println("---------------------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getUser().getName());
        System.out.println("Restaurant: " + order.getRestaurant().getName());
        System.out.println("Items Ordered:");

        List<MenuItem> items = order.getItems();
        for (MenuItem item : items) {
            System.out.println("   - " + item.getName() + " (Rs." + item.getPrice() + ")");
        }

        System.out.println("Total: Rs." + order.getTotalPrice());
        System.out.println("Scheduled For: " + order.getScheduled());
        System.out.println("Payment: Done");
        System.out.println("---------------------------------------------");
    }
}
