package com.fw.week9;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 주문 이벤트 발행자.
 *
 * ApplicationEventPublisher 를 주입받아 OrderEvent 를 발행한다.
 * (ApplicationContext 자체가 ApplicationEventPublisher 를 구현하고 있으므로
 *  별도 설정 없이 스프링 빈에 바로 주입받아 사용할 수 있다.)
 */
@Component
public class OrderPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public OrderPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(OrderEvent event) {
        event.setStatus(OrderStatus.WAIT);

        System.out.println("[OrderPublisher] 주문 이벤트 발행 -> " + event);
        eventPublisher.publishEvent(event);
    }
}
