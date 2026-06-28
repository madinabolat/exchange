package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //https://docs.cdp.coinbase.com/coinbase-app/advanced-trade-apis/guides/websocket
        // Market Data Endpoint: wss://advanced-trade-ws.coinbase.com
        //https://www.coinbase.com/advanced-trade/spot/BTC-USD
        //https://exchange.coinbase.com/trade/BTC-USD

        //ERD: https://app.diagrams.net/#G1hgrhV9jOj7XXqAWOdYGd38nnsdbiwwSs#%7B%22pageId%22%3A%2208UJjrRjVVuL9m5ZP48K%22%7D

        OrderStorage orderStorage = new OrderStorage();
        CoinbaseWebSocketClient coinbaseWebSocketClient = new CoinbaseWebSocketClient(orderStorage);
        coinbaseWebSocketClient.connect();
        Thread.sleep(3000);
        for (Order order : orderStorage.getOrders()){
            System.out.println(order);
        }
    }
}