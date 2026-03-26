package com.fw.week5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import jakarta.annotation.Resource;

public class HelloService {

    @Autowired
    @Qualifier("myService")
    private MyService myService;

    @Resource(name = "gamjaService")
    private MyService gamjaService;

    public void sayHello() {
        System.out.println("========================================");
        System.out.println("  [@Autowired] MyServiceImpl 호출");
        System.out.println("========================================");
        myService.hello();

        System.out.println();
        System.out.println("========================================");
        System.out.println("  [@Resource] GamjaServiceImpl 호출");
        System.out.println("========================================");
        gamjaService.hello();
    }
}
