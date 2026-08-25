package com.fw;

import com.fw.week9.AppConfig;
import com.fw.week9.OrderEvent;
import com.fw.week9.OrderPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    OrderEvent event = new OrderEvent();
    event.orderId = 2026L;
    event.name = "우시영";
    event.count = 824;

    OrderPublisher orderPublisher = context.getBean(OrderPublisher.class);
    orderPublisher.publish(event);
  }
}