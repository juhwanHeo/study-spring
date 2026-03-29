package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import com.fw.week5.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new GenericXmlApplicationContext("week5.xml");

    HelloService helloService = (HelloService) context.getBean("helloService");
    helloService.sayHello();

    context.close();
  }
}