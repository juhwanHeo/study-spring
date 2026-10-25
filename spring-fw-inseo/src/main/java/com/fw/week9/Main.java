package com.fw.week9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            OrderPublisher publisher =
                    context.getBean(OrderPublisher.class);

            OrderEvent orderEvent =
                    new OrderEvent(1L, "노트북", 2);

            publisher.publish(orderEvent);
        }
    }
}