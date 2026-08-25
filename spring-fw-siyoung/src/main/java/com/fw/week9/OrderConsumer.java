package com.fw.week9;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {
  @EventListener
  public void consume(OrderEvent event) {
    event.status = OrderStatus.COMPLETED;
    log.info("OrderEvent consumed: {}", event);
  }
}
