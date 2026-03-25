package com.fw.week4;

import com.fw.week4.Food;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthDate;
    private Food favoriteFood;

    public Person() {}

    public Person(String name, int age, String gender, String birthDate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    // ── 1. Lifecycle Callbacks ──────────────────────────────
    @PostConstruct
    public void init() {
        System.out.println("  [Person] >>> @PostConstruct 호출됨 - 빈 초기화 완료: name=" + name + ", age=" + age);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  [Person] >>> @PreDestroy 호출됨 - 빈 소멸 예정: name=" + name);
    }

    // ── Getters / Setters ───────────────────────────────────
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
