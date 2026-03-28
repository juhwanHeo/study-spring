package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
      ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("week4.xml");
      Person person = context.getBean("hyunjin",Person.class);
      Vegetable vegetable = context.getBean("vegetable",Vegetable.class);

      person.hello();
      vegetable.print();

      context.close();
  }
}