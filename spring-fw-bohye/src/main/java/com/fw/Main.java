package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Food;
import com.fw.week3.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("week4.xml");
        Person person = context.getBean("bohye", Person.class);
        person.hello();
        log.info("person bean: {}", person);

        Food food = context.getBean("food", Food.class);
        log.info("food bean: {}", food);

        Vegetable vegetable = context.getBean("vegetable", Vegetable.class);
        vegetable.yummy();
        log.info("vegetable bean: {}", vegetable);

        context.close();
    }
}