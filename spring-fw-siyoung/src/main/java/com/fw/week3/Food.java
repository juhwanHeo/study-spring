package com.fw.week3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Food {
  String name;
  String type;

  public void setName(String name) {
    this.name = name;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  @PostConstruct
  public void init() {
    System.out.println("Food Init");
  }

  @PreDestroy
  public void shutdown() {
    System.out.println("Food Shutdown");
  }
}
