package com.fw;

import com.fw.week9.AppConfig;
import com.fw.week9.OrderEvent;
import com.fw.week9.OrderPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {

    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {

      OrderPublisher orderPublisher = context.getBean(OrderPublisher.class);
      OrderEvent event = new OrderEvent(1000000L, "감자", 2);

      orderPublisher.publish(event);
    }
  }
}