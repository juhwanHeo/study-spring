package com.fw.week9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {

    @EventListener
    public void consume(OrderEvent event) {
        event.setStatus(OrderStatus.COMPLETED);
        log.info("[소비] orderId={}, name={}, count={}, status={}",
                event.getOrderId(),
                event.getName(),
                event.getCount(),
                event.getStatus());
    }
}