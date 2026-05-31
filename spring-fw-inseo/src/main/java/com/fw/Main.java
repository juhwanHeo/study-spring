package com.fw;

import com.fw.week5.HelloService;
import com.fw.week6.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloService helloService = context.getBean(HelloService.class);
        helloService.sayHello();

        context.close();
    }
}