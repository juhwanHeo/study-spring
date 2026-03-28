package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Food;
import com.fw.week3.Vegetable;
import com.fw.week5.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("week5.xml")) {
      HelloService helloService = context.getBean("helloService", HelloService.class);
      helloService.sayHello();
    }
  }
}