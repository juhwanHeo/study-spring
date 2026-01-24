package com.fw.week2;
import com.fw.week3.Food;

public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthDate;
    private Food food;

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
