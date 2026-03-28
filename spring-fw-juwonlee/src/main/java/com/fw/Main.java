package com.fw;

import com.fw.week5.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("week5.xml");
        HelloService helloService = context.getBean(HelloService.class);

        helloService.sayHello();

        context.close();
    }
}
