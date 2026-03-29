package com.fw.week2;

public class Person{
    /*
    name : 이름
    age : 나이
    gender : 성별(F / M)
    birthDate : 생일 ( YYYY-MM-DD)
     */

    private String name;
    private  int age;
    private  GenderType gender;
    private String birthDate;

    public Person() {
        System.out.println("Person 생성!");
    }
    // Getter / Setter

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

    public enum GenderType {
        M, // male
        F  // female
    }

    public void hello() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        System.out.println("gender: " + gender);
        System.out.println("birth date: " + birthDate);
    }

}
