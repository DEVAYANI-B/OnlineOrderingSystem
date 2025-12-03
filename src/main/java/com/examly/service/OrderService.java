package main.java.com.examly.service;

import main.java.com.examly.entity.Order;
import java.util.*;
import main.java.com.examly.Exception.*;

public interface OrderService{
     boolean customerExists(String customerId);
     boolean itemExists(String itemId);
     boolean placeOrder(Order order) throws CustomerNotFoundException,ItemNotFoundException;
     List<Order> getOrdersByCustomer(String customerId);
}