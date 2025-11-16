package com.fw.week2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthDate;

    public void hello() {
        log.info("name: {}", name);
        log.info("age: {}", age);
        log.info("gender: {}", gender);
        log.info("birth date: {}", birthDate);
    }
}
