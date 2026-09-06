package com.fw.week9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

@Slf4j
public class OrderPublisher implements ApplicationEventPublisherAware {

  private ApplicationEventPublisher publisher;

  // Spring이 자동으로 호출해서 publisher를 주입해줌
  public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
    this.publisher = publisher;
  }

  public void publish(OrderEvent event) {
    event.setStatus(OrderStatus.WAIT);
    log.info("[Publisher] OrderId: {}, Name: {}, Count: {}, Status: {}",
        event.getOrderId(), event.getName(), event.getCount(), event.getStatus());
    publisher.publishEvent(event);
  }
}