package com.fw.week2;

public class Person {
  private String name;
  private int age;
  private String gender;
  private String birthDate;

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
    System.out.printf("%n저는 %d살 %s 성별을 가진 %s이라고 합니다. 생일은 %s일 입니다. %n", age, gender, name, birthDate);
  }
}
