package com.fw.week5;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectProvider;
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


    @Autowired
    @Qualifier("gamjaServiceImpl")
    private ObjectProvider<MyService> gamjaServiceProvider;

    public void sayHello() {
        myService.hello();
        gamjaService.hello();
        MyService service = gamjaServiceProvider.getObject();
        service.hello();
    }

    public void providerHello() {
        MyService gamjaService = gamjaServiceProvider.getObject();
        gamjaService.hello();
    }
}