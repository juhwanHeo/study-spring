package com.fw.week2;

import com.fw.week3.Food;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthDate;

    private Food food;

    public Person() {
        log.info("Person created (constructor called).");
    }

    public void hello() {
        log.info("name: {}", name);
        log.info("age: {}", age);
        log.info("gender: {}", gender);
        log.info("birth date: {}", birthDate);
        log.info("food: {}", food);
    }
}
