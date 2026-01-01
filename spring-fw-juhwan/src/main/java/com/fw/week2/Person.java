package com.fw.week2;

import com.fw.week3.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Person {

  /*
    name: 이름
    age: 나이
    gender: 성별 (F / M)
    birthDate: 생일 (YYYY-MM-DD)
  */
  private String name;
  private int age;
  private GenderType gender;
  private String birthDate;
  private Food food;

  public Person() {
    log.info("Person 생성!");
  }

  public enum GenderType {
    M, // male
    F, // female
  }

  public void hello() {
    log.info("name: {}", name);
    log.info("age: {}", age);
    log.info("gender: {}", gender);
    log.info("birth date: {}", birthDate);
    log.info("food: {}", food);
  }
}
