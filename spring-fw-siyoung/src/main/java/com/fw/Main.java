package com.fw;

import com.fw.week5.MyService;
import com.fw.week5.Week6Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Week6Configuration.class)) {
      MyService myService = context.getBean("myServiceImpl", MyService.class);
      myService.hello();

      for (int i = 0; i < 10; i++) {
        MyService gamjaService = context.getBean("gamjaServiceImpl", MyService.class);
//        gamjaService.hello();
      }
    }
  }
}