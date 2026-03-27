package com.fw.week2;

import com.fw.week3.Food;
import com.fw.week3.Vegetable;

public class Person {

    private String name;
    private int age;
    private GenderType gender;
    private String birthDate;

    // ✅ 추가
    private Food food;


    public Person() {
        System.out.println("Person 생성!");
    }

    // 기존 Getter / Setter 유지

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    // ✅ Food setter 추가
    public void setFood(Food food) {
        this.food = food;
    }



    public enum GenderType {
        M, F
    }

    public void hello() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
        System.out.println("birth date: " + birthDate);

        // ✅ 추가 출력
        if (food != null) {
            food.print();
        }

    }
}