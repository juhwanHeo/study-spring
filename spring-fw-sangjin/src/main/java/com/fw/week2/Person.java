package com.fw.week2;

import com.fw.week3.Food;

public class Person {
    private String name;      // 이름
    private int age;          // 나이
    private String gender;    // 성별 (F / M)
    private String birthDate; // 생일 (YYYY-MM-DD)
    private Food favoriteFood; // 좋아하는 음식

    public Person() {}

    public Person(String name, int age, String gender, String birthDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    // getters / setters (JavaBean 규약)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public Food getFavoriteFood() { return favoriteFood; }
    public void setFavoriteFood(Food favoriteFood) { this.favoriteFood = favoriteFood; }

    // 소개 메서드
    public void hello() {
        String foodInfo = favoriteFood != null ? 
            ", 좋아하는 음식은 " + favoriteFood.getName() + "(" + favoriteFood.getType() + ")" : "";
        System.out.println(
                "안녕하세요, 저는 " + name + "입니다. 나이 " + age +
                        ", 성별 " + gender + ", 생일 " + birthDate + foodInfo + " 입니다."
        );
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", favoriteFood=" + favoriteFood +
                '}';
    }
}