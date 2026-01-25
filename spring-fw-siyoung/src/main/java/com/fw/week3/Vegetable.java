package com.fw.week3;

public class Vegetable {
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

  public void introduce() {
    System.out.printf("음식: %s / 종류 : %s %n", name, type);
  }
}
