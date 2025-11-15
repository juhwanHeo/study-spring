package com.fw;

import com.fw.week2.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    log.info("Hello World");
      ApplicationContext context = new ClassPathXmlApplicationContext("week2.xml");
      Person person = context.getBean("juwonlee", Person.class);
      person.hello();
  }
}
