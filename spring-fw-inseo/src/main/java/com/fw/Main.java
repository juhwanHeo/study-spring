package com.fw;

import com.fw.week5.HelloService;
import com.fw.week5.MyService;
import com.fw.week6.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloService helloService = context.getBean(HelloService.class);
        helloService.sayHello();

        System.out.println("----- GamjaServiceImpl prototype scope 확인 -----");

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "번째 GamjaServiceImpl 호출");
            MyService gamjaService =
                    context.getBean("gamjaServiceImpl", MyService.class);
            gamjaService.hello();
        }

        context.close();
    }
}