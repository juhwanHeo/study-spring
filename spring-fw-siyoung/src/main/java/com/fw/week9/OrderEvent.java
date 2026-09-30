package com.fw.week9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class OrderEvent {
  public Long orderId;
  public String name;
  public int count;
  public OrderStatus status;
}
