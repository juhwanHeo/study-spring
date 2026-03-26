package com.fw.week5;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Week5Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  Week5: @Autowired, @Resource, @Value 실습");
        System.out.println("========================================\n");

        try (ClassPathXmlApplicationContext ctx =
                     new ClassPathXmlApplicationContext("week5.xml")) {

            HelloService helloService = ctx.getBean("helloService", HelloService.class);
            helloService.sayHello();

            System.out.println();
            System.out.println("========================================");
        }
    }
}
