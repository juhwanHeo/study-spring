package com.fw.week9;

import lombok.ToString;

@ToString
public class OrderEvent {
  public Long orderId;
  public String name;
  public int count;
  public OrderStatus status;

}
