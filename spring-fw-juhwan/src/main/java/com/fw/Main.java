package com.fw;

import com.fw.week5.MyServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("week5.xml");

    MyServiceImpl myService = context.getBean("myServiceImpl", MyServiceImpl.class);
    myService.hello();

    context.close();
  }
}