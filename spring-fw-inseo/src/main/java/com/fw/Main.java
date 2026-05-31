package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("week4.xml");

        // 1. Person 먼저 호출
        Person person = context.getBean("inseo", Person.class);
        person.hello();

        System.out.println("----- Bean Definition Inheritance -----");

        Person inheritPerson = context.getBean("inheritPerson", Person.class);
        inheritPerson.hello();


        context.close();
    }
}