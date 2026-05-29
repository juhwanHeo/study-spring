package com.fw.week5;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
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
