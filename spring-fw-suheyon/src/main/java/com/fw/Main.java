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
    Food food = context.getBean("financier", Food.class);

    // suhyeon.hello();

    log.info("\nFood bean: name={}, type={}", food.getName(), food.getType());
    log.info("\nPerson bean:name={}, birthDate={}, age={}, gender={}, food={}", suhyeon.getName(), suhyeon.getBirthDate(), suhyeon.getAge(), suhyeon.getGender(), suhyeon.getFood());
  }
}