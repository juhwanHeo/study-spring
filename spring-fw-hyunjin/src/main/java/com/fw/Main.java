package com.fw;

import com.fw.week9.AppConfig;
import com.fw.week9.OrderEvent;
import com.fw.week9.OrderPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            OrderPublisher publisher = context.getBean(OrderPublisher.class);
            publisher.publish(new OrderEvent(3333L, "고구마", 100));
        }
    }
}