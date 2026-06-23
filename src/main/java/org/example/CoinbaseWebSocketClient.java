package org.example;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class CoinbaseWebSocketClient extends WebSocketClient {
    static final URI COINBASE_URL = URI.create("wss://advanced-trade-ws.coinbase.com");
    public CoinbaseWebSocketClient() {
        super(COINBASE_URL);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        String subscribeMessage = """
                    {
                        "type": "subscribe",
                        "product_ids": [
                            "ETH-USD",
                            "ETH-EUR"
                        ],
                        "channel": "level2"
                    }
                """;
        send(subscribeMessage);
        System.out.println("Connected.");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("received: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Closed");

    }

    @Override
    public void onError(Exception ex) {

    }
    //https://docs.cdp.coinbase.com/coinbase-app/advanced-trade-apis/websocket/websocket-overview

//Market Data Endpoint: wss://advanced-trade-ws.coinbase.com

}
