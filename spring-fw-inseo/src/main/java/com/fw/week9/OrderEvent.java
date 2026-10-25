package com.fw.week9;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class OrderEvent {

    private final Long orderId;
    private final String name;
    private final int count;

    @Setter
    private OrderStatus status;
}