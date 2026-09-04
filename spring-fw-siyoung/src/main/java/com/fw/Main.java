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
    OrderEvent event = new OrderEvent(2026L, "우시영", 824, null);

    OrderPublisher orderPublisher = context.getBean(OrderPublisher.class);
    orderPublisher.publish(event);
  }
}