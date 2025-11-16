package com.fw.week2;

public class Person {

    private String name;
    private int age;
    private String gender;
    private String birthDate;

    public Person() {}

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
        System.out.println("안녕하세요! 저는 " + name + "입니다.");
        System.out.println("나이: " + age);
        System.out.println("성별: " + gender);
        System.out.println("생일: " + birthDate);
    }
}
