package com.fw.week2;
import com.fw.week3.Food;
import com.fw.week3.Vegetable;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Person {
    // 1. 필드 선언
    private String name;
    private int age;
    private String gender;
    private String birthDate;
    private Food food;
    private Vegetable vegetable;

    // 2. 기본 생성자 (Default Constructor)
    public Person() {
        System.out.println("Person 객체 생성!");
    }

    // 3. Setter 메서드
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    public void setFood(Food food){
        this.food = food;
    }
    public void setVegetable(Vegetable vegetable){}

    // 초기화 콜백
    @PostConstruct
    public void init(){
        System.out.println("Person @PostConstructor 실행");
    }

    // 소멸 콜백
    @PreDestroy
    public void destroy() {
        System.out.println("Person @PreDestroy 실행");
    }


    public void hello() {
        System.out.printf("-------------------- %n저를 소개합니다. %n" +
                "이름 : %s %n" +
                "나이 : %d %n" +
                "성별 : %s %n" +
                "생일 : %s %n" +
                "좋아하는 음식 : %s %n" +
                "만나서 반갑습니다 :)%n-------------------- ", name, age, gender, birthDate, food);
    }
}
