package com.fw.week2;

import com.fw.week3.Food;
import com.fw.week3.Vegetable;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

  @PostConstruct
  public void initialize() {
    log.info("Person 탄생!");
  }

  @PreDestroy
  public void destroy() {
    log.info("Person 파괴!");
  }

  public void hello() {
    log.info("이름은 {} 나이 {}의 성별 {}인 사람. 생일은 {}입니다.", name,  age, gender, birthDate);
    Optional.ofNullable(food).ifPresentOrElse(
        f -> log.info("좋아하는 음식은 {} {}입니다.", f.getType(),  f.getName()),
        () -> log.info("좋아하는 음식이 없습니다.")
    );
  }
}
