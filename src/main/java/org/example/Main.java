package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // "Coinbase WebSocket API BTC-USD"
        //https://docs.cdp.coinbase.com/coinbase-app/advanced-trade-apis/guides/websocket
        //https://docs.cdp.coinbase.com/coinbase-app/advanced-trade-apis/websocket/websocket-channels

        CoinbaseWebSocketClient coinbaseWebSocketClient = new CoinbaseWebSocketClient();
        coinbaseWebSocketClient.connect();


    }
}