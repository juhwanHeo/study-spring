package com.fw.week9;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 주문 이벤트 소비자.
 *
 * @EventListener 를 붙인 메서드는 스프링이 자동으로 ApplicationListener 로 등록해준다.
 * 메서드 파라미터 타입(OrderEvent)을 기준으로 어떤 이벤트를 수신할지 결정된다.
 * 별도의 TaskExecutor 설정이 없으므로 발행(publish) 스레드에서 동기적으로 즉시 호출된다.
 */
@Component
public class OrderConsumer {

    @EventListener
    public void consume(OrderEvent event) {
        System.out.println("[OrderConsumer] 주문 이벤트 수신 <- " + event);

        event.setStatus(OrderStatus.COMPLETED);

        System.out.println("[OrderConsumer] 주문 처리 완료 -> " + event);
    }
}
