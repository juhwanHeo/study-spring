package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");
        ApplicationContext context = new ClassPathXmlApplicationContext("week3.xml");
        Person person = context.getBean("bohye", Person.class);
        person.hello();

        Vegetable vegetable = context.getBean("vegetable", Vegetable.class);
        vegetable.yummy();
    }
}