package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new GenericXmlApplicationContext("week4.xml");
    Person person = (Person) context.getBean("yiseul");
    Vegetable vegetable = (Vegetable) context.getBean("vegetable");
    person.hello();
    vegetable.print();

    context.registerShutdownHook();
  }
}