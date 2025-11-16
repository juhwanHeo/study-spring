package com.fw.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private String name;
  private int age;
  private String gender;
  private String birthDate;

  public void hello() {
    log.info("이름은 {} 나이 {}의 성별 {}인 사람. 생일은 {}입니다.", name,  age, gender, birthDate);
  }
}
