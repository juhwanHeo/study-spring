package com.fw;

import com.fw.week5.HelloService;
import com.fw.week6.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);

    HelloService helloService = context.getBean(HelloService.class);
    helloService.sayHello();

    for (int i = 0; i < 10; i++) {
      context.getBean("gamjaServiceImpl");
    }
  }
}