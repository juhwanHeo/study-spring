package com.fw;

import com.fw.week9.AppConfig;
import com.fw.week9.OrderEvent;
import com.fw.week9.OrderPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            OrderPublisher orderPublisher = context.getBean(OrderPublisher.class);
            orderPublisher.publish(new OrderEvent(1000L, "고구마", 10));
        }
    }
}
