package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Food;
import com.fw.week3.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("week2.xml", "week3.xml")) {
      Person person = context.getBean(Person.class);
      person.hello();

      Food food = context.getBean(Food.class);
      food.introduce();

      Vegetable vegetable = context.getBean(Vegetable.class);
      vegetable.introduce();
    }
  }
}