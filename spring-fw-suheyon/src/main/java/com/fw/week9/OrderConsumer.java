package com.fw.week9;

import org.springframework.context.ApplicationListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderConsumer implements ApplicationListener<OrderEvent> {

  @Override
  public void onApplicationEvent(OrderEvent orderEvent) {
    consume(orderEvent);
  }

  public void consume(OrderEvent event) {
    event.setStatus(OrderStatus.COMPLETED);
    log.info("[Consumer] OrderId: {}, Name: {}, Count: {}, Status: {}",
        event.getOrderId(), event.getName(), event.getCount(), event.getStatus());
  }

}