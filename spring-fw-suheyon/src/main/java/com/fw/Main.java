package com.fw;

import com.fw.week5.HelloService;
import com.fw.week6.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {

    // xml
    // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("week5.xml");
    // AppConfig
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    HelloService helloService = context.getBean(HelloService.class);
    helloService.sayHello();

    context.close();
  }
}