package com.fw.week5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloService {

    @Autowired
    @Qualifier("myServiceImpl")
    private MyService myService;

    @Autowired
    @Qualifier("gamjaServiceImpl")
    private MyService gamjaService;

    public void sayHello() {
        myService.hello();
        gamjaService.hello();
    }
}