package com.fw.week2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.fw.week3.Food;

@Slf4j
@Data
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private String gender;
    private String birthDate;
    private Food food;

    public void hello() {
        log.info("Person info: {}", this);
    }
}