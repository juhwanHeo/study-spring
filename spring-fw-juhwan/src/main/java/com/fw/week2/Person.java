package com.fw.week2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
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

  public enum GenderType {
    M, // male
    F, // female
  }

  public void hello() {
    log.info("name: {}", name);
    log.info("age: {}", age);
    log.info("gender: {}", gender);
    log.info("birth date: {}", birthDate);
  }
}
