package com.fw.week9;

import org.springframework.context.ApplicationEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderEvent extends ApplicationEvent {

  private Long orderId;
  private String name;
  private int count;
  private OrderStatus status;

  public OrderEvent(Object source, Long orderId, String name, int count, OrderStatus status) {
    super(source); // 이벤트를 발생시킨 객체(source)를 부모에 전달
    this.orderId = orderId;
    this.name = name;
    this.count = count;
    this.status = status;
  }
}
