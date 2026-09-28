package com.fw.week9;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPublisher {

    private final ApplicationEventPublisher publisher;

    public void publish(OrderEvent event) {
        event.setStatus(OrderStatus.WAIT);

        log.info(
                "주문 이벤트 발행: orderId={}, name={}, count={}, status={}",
                event.getOrderId(),
                event.getName(),
                event.getCount(),
                event.getStatus()
        );

        publisher.publishEvent(event);
    }
}