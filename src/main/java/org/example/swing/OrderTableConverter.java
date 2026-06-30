package org.example.swing;

import org.example.entity.Order;
import org.example.storage.OrderStorage;


public class OrderTableConverter {
    OrderStorage orderStorage;

    public OrderTableConverter(OrderStorage orderStorage){
        this.orderStorage = orderStorage;
    }

    public Object[][] convertOrderToTable(){
        Object[][] orderArray = new Object[orderStorage.getOrders().size()][4] ;
        return orderArray;
    }


}
