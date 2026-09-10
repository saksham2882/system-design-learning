package lecture_09_Design_a_Food_Delivery_App.foodXpress.factories;

import lecture_09_Design_a_Food_Delivery_App.foodXpress.models.*;
import lecture_09_Design_a_Food_Delivery_App.foodXpress.strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {

    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems, PaymentStrategy paymentStrategy, double totalPrice, String orderType);
}
