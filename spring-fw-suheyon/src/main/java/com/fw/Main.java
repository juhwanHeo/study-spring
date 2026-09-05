package com.fw;

import com.fw.week9.AppConfig;
import com.fw.week9.OrderEvent;
import com.fw.week9.OrderPublisher;
import com.fw.week9.OrderStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    OrderPublisher publisher = ctx.getBean(OrderPublisher.class);
    OrderEvent orderEvent = new OrderEvent(publisher, 1L, "cake", 10, OrderStatus.WAIT);

    publisher.publish(orderEvent);
    ctx.close();
  }
}