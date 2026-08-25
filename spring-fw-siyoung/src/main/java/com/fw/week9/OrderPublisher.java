package com.fw.week9;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderPublisher {
  private final ApplicationEventPublisher applicationEventPublisher;

  public void publish(OrderEvent event) {
    event.status = OrderStatus.WAIT;
    log.info("OrderEvent published: {}", event);
    applicationEventPublisher.publishEvent(event);
  }
}
