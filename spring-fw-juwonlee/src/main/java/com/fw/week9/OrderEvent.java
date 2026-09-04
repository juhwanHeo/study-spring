package com.fw.week9;

import lombok.Data;

@Data
public class OrderEvent {
    private final Long orderId;
    private final String name;
    private final int count;
    private OrderStatus status;

    public OrderEvent(Long orderId, String name, int count) {
        this(orderId, name, count, null);
    }

    public OrderEvent(Long orderId, String name, int count, OrderStatus status) {
        this.orderId = orderId;
        this.name = name;
        this.count = count;
        this.status = status;
    }
}
