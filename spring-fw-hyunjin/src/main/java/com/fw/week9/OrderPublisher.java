package com.fw.week9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public OrderPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(OrderEvent event) {
        event.setStatus(OrderStatus.WAIT);
        log.info("[발행] orderId={}, name={}, count={}, status={}",
                event.getOrderId(),
                event.getName(),
                event.getCount(),
                event.getStatus());

        eventPublisher.publishEvent(event);
    }
}