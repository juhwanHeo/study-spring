package com.fw;

import com.fw.week5.MyService;
import com.fw.week5.Week6Configuration;
import com.fw.week7.AppConfig;
import com.fw.week7.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Week6Configuration.class, AppConfig.class);
    MyService myService = context.getBean("myServiceImpl", MyService.class);
    myService.hello();

    for (int i = 0; i < 5; i++) {
      myService.hello();
    }

    Transfer transfer = context.getBean("Transfer", Transfer.class);
    transfer.transfer();
  }
}