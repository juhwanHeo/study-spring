package com.fw;

import com.fw.week5.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    HelloService helloService = (HelloService) context.getBean("helloService");
    helloService.sayHello();

    for (int i = 0; i < 10; i++) {
      context.getBean("gamjaService");
    }
  }
}