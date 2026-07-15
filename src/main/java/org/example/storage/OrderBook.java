package org.example.storage;

import org.example.entity.Order;

import java.util.PriorityQueue;

public class OrderBook {
    PriorityQueue<Order> buyBook;
    PriorityQueue<Order> sellBook;

    public OrderBook(){
        this.buyBook = new PriorityQueue<>((Order order1, Order order2) -> (int) (order1.getPriceLevel() - order2.getPriceLevel()));
        this.sellBook = new PriorityQueue<>((Order order1, Order order2) -> (int) (order1.getPriceLevel() - order2.getPriceLevel()));
        //if order1 price < order 2 price -> negative -> order1 comes first, order 2 after. so this is sorted by smallest first.

    }
}
