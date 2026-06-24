package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CoinbaseWebSocketClient extends WebSocketClient {
    static final URI COINBASE_URL = URI.create("wss://advanced-trade-ws.coinbase.com");
    OrderParser orderParser;
    OrderStorage orderStorage;
    public CoinbaseWebSocketClient(OrderStorage orderStorage) {
        super(COINBASE_URL);
        this.orderParser = new OrderParser();
        this.orderStorage = orderStorage;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        String subscribeMessage = """
                    {
                        "type": "subscribe",
                        "product_ids": [
                            "BTC-USD"
                        ],
                        "channel": "level2"
                    }
                """;
        send(subscribeMessage);
        System.out.println("Connected.");
    }

    @Override
    public void onMessage(String message) {
        try {
            List<Order> ordersList = orderParser.parse(message);
            System.out.println("Parsed " + ordersList.size() + " orders");
            for (Order order : ordersList){
                orderStorage.addOrder(order);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Connectino closed.");
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}
