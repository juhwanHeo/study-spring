package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Food;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ApplicationContext context =  new ClassPathXmlApplicationContext("week3.xml");
    Person suhyeon = (Person) context.getBean("suhyeon");

    // suhyeon.hello();

    Food food = context.getBean("financier", Food.class);
    log.info("\nFood bean: name={}, type={}", food.getName(), food.getType());
  }
}