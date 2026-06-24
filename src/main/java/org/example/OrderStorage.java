package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderStorage {
    Queue<Order> orderQueue;
    private static final int MAX_ORDERS_COUNT = 100;

    public OrderStorage() {
        this.orderQueue = new LinkedList<>();
    }

    public void addOrder(Order order){
        if (orderQueue.size() == MAX_ORDERS_COUNT){
            orderQueue.remove();
        }
        orderQueue.add(order);
    }

    public List<Order> getOrders(){
        return new ArrayList<>(orderQueue);
    }

    public void printOrders(){
        for (Order order : orderQueue){
            System.out.println(order);
        }
    }
}
