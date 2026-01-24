package com.fw.week2;

import com.fw.week3.Food;
import com.fw.week3.Vegetable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Person {
  private String name;
  private int age;
  private String gender;
  private String birthDate;
  private Food food;

  Person() {
    log.info("Person 생성!");
  }

  public void hello() {
    log.info("이름은 {} 나이 {}의 성별 {}인 사람. 생일은 {}입니다.", name,  age, gender, birthDate);
    log.info("좋아하는 음식은 {} {}입니다.", food.getType(),  food.getName());
  }
}
