package com.fw.week2;

import com.fw.week3.Food;

public class Person {
  private String name; // JoSuhyeon
  private int age; // 25
  private String gender; // F/M
  private String birthDate; // YYYY-MM-DD

  private Food food;

  public void hello() {
    System.out.printf(
        "Hello! My name is %s. I was born on %s, and I am currently %d years old. My gender is %s.",
        name, birthDate, age, gender
    );
  }

  // Setter
  public void setName(String name) {this.name = name;}
  public void setAge(int age) { this.age = age; }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
  public void setFood(Food food) { this.food = food; }

  // Getter
  public String getName() { return this.name; }
  public int getAge() {
    return this.age;
  }
  public String getGender() {
    return this.gender;
  }
  public String getBirthDate() { return this.birthDate;}
}
