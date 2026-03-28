package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("week4.xml"); // 🔥 week4로 변경

        // 1. Person 먼저 호출
        Person person = context.getBean("person", Person.class);
        person.hello();

        context.close();
    }
}