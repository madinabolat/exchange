package org.example;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;

public class OrderParser {
    Gson gson;

    public OrderParser(){
        this.gson = new Gson();
    }

    public List<Order> parse(String message){
        List<Order> ordersList = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(message).getAsJsonObject();
        JsonArray eventsArray = jsonObject.getAsJsonArray("events");
        for (JsonElement event : eventsArray){
            JsonArray updatesArray = event.getAsJsonObject().getAsJsonArray("updates");
            if (updatesArray == null){
                continue;
            }
            for (JsonElement update : updatesArray){
                Order order = gson.fromJson(update, Order.class);
                ordersList.add(order);
            }
        }
        return ordersList;
    }

}

//        {"side":"offer","event_time":"2026-06-24T00:53:06.702512Z","price_level":"180000.01","new_quantity":"0.11619038"},
//        {"side":"offer","event_time":"2026-06-24T00:53:06.702512Z","price_level":"180000.6","new_quantity":"0.00018611"},

//{
//        "channel": "l2_data",
//        "client_id": "",
//        "timestamp": "2023-02-09T20:32:50.714964855Z",
//        "sequence_num": 0,
//        "events": [
//        {
//        "type": "snapshot",
//        "product_id": "BTC-USD",
//        "updates": [
//        {
//        "side": "bid",
//        "event_time": "1970-01-01T00:00:00Z",
//        "price_level": "21921.73",
//        "new_quantity": "0.06317902"
//        },
//        {
//        "side": "bid",
//        "event_time": "1970-01-01T00:00:00Z",
//        "price_level": "21921.3",
//        "new_quantity": "0.02"
//        }
//        ]
//        }
//        ]
//        }
