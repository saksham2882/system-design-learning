package lecture_09_Design_a_Food_Delivery_App.foodXpress.factories;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.*;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies.PaymentStrategy;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.utils.TimeUtils;

import java.util.List;

public class ScheduledOrderFactory implements OrderFactory{

    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime){
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalPrice, String orderType) {
        Order order = null;

        if(orderType.equalsIgnoreCase("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        } else {
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(menuItems);
        order.setPaymentStrategy(paymentStrategy);
        order.setTotalPrice(totalPrice);
        order.setScheduled(scheduleTime);

        return order;
    }
}
