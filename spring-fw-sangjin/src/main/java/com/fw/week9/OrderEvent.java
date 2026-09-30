package com.fw.week9;

/**
 * 주문 이벤트(command 성격의 페이로드 객체).
 *
 * Spring Framework 4.2 부터는 이벤트 클래스가 ApplicationEvent 를 상속할 필요가 없고,
 * 순수 POJO 를 그대로 ApplicationEventPublisher.publishEvent(Object) 로 발행할 수 있다.
 * (내부적으로 PayloadApplicationEvent 로 감싸져 전달된다.)
 */
public class OrderEvent {

    private final Long orderId;
    private final String name;
    private final int count;
    private OrderStatus status;

    public OrderEvent(Long orderId, String name, int count) {
        this.orderId = orderId;
        this.name = name;
        this.count = count;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderEvent{" +
                "orderId=" + orderId +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", status=" + status +
                '}';
    }
}
