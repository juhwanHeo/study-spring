package com.fw.week5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import jakarta.annotation.Resource;

public class HelloService {

    @Autowired
    @Qualifier("myServiceImpl")
    private MyService myService;

    @Resource
    @Qualifier("gamjaServiceImpl")
    private MyService gamjaService;

    public void sayHello() {
        myService.hello();
        gamjaService.hello();
    }
}