package com.fw.week9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderPublisher implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher eventPublisher;

  @Override
  public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
    this.eventPublisher = applicationEventPublisher;
  }

  public void publish(OrderEvent event) {
    event.setStatus(OrderStatus.WAIT);
    log.info(
        "주문 이벤트 발행: orderId={}, name={}, count={}, status={}",
        event.getOrderId(),
        event.getName(),
        event.getCount(),
        event.getStatus());

    eventPublisher.publishEvent(event);
  }
}
