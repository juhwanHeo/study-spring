package com.fw.week9;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Week9Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("  Week9: OrderEvent 발행/소비 (ApplicationEvent)");
        System.out.println("==================================================\n");

        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            OrderPublisher orderPublisher = ctx.getBean(OrderPublisher.class);

            OrderEvent orderEvent = new OrderEvent(1001L, "감자", 5);

            System.out.println("--------------------------------------------------");
            System.out.println("주문 이벤트 발행 전 상태: " + orderEvent.getStatus());
            System.out.println("--------------------------------------------------");

            orderPublisher.publish(orderEvent);

            // 기본 ApplicationEventMulticaster는 동기(synchronous) 방식이므로
            // publish() 호출이 끝난 시점에는 OrderConsumer.consume() 처리까지 완료되어 있다.
            System.out.println("--------------------------------------------------");
            System.out.println("주문 이벤트 소비 후 최종 상태: " + orderEvent.getStatus());
            System.out.println("--------------------------------------------------");
        }
    }
}
