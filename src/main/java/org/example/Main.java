package org.example;

import org.example.client.CoinbaseWebSocketClient;
import org.example.entity.Order;
import org.example.storage.OrderStorage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        OrderStorage orderStorage = new OrderStorage();
        CoinbaseWebSocketClient coinbaseWebSocketClient = new CoinbaseWebSocketClient(orderStorage);
        coinbaseWebSocketClient.connect();
        Thread.sleep(3000);//redo - explore
        for (Order order : orderStorage.getOrders()){
            System.out.println(order);
        }
    }
}