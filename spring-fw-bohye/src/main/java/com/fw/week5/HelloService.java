package com.fw.week5;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    @Autowired
    private MyServiceImpl myServiceImpl;

    @Resource
    private GamjaServiceImpl gamjaServiceImpl;

    public void sayHello() {
        myServiceImpl.hello();
        gamjaServiceImpl.hello();
    }
}
