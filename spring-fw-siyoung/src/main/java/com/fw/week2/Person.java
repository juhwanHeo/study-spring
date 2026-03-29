package com.fw.week2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import com.fw.week3.Food;

public class Person {
  private String name;
  private int age;
  private String gender;
  private String birthDate;

  private Food food;

  public void setFood(Food food) {
    this.food = food;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }
  public void hello() {
    System.out.printf("나이 : %s / 이름 : %s %n", age, name);
    System.out.printf("음식 : %s / 종류 : %s %n", food.getName(), food.getType());
  }

  @PostConstruct
  public void init() {
    System.out.println("Person Init");
  }

  @PreDestroy
  public void shutdown() {
    System.out.println("Person Shutdown");
  }
}
