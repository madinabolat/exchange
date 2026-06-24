package org.example;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.time.LocalDateTime;

public class Order {

    private OrderSide side;

    @SerializedName("event_time")
    private String eventTime;

    @SerializedName("price_level")
    private double priceLevel;

    @SerializedName("new_quantity")
    private double newQuantity;

    public Order(OrderSide side, String eventTime, double priceLevel, double newQuantity){
        this.side = side;
        this.eventTime = eventTime;
        this.priceLevel = priceLevel;
        this.newQuantity = newQuantity;
    }

    public OrderSide getSide() {
        return side;
    }

    public String getEventTime() {
        return eventTime;
    }

    public double getPriceLevel() {
        return priceLevel;
    }

    public double getNewQuantity() {
        return newQuantity;
    }

    @Override
    public String toString() {
        return "Order: {"+side + ", " + eventTime + ", " + priceLevel + ", " + newQuantity + "}";
    }
}
