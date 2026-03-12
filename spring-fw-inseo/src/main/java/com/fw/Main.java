package com.fw;

import com.fw.week2.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("week2.xml");

        Person person = (Person) context.getBean("inseo");

        person.hello();
    }
}