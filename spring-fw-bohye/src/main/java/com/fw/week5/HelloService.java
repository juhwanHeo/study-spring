package com.fw.week5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HelloService {

    @Autowired
    @Qualifier("myServiceImpl")
    private MyService myServiceImpl;

    @Autowired
    @Qualifier("gamjaServiceImpl")
    private MyService gamjaServiceImpl;

    public void sayHello() {
        myServiceImpl.hello();
        gamjaServiceImpl.hello();
    }
}
