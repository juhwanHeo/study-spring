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
    private ObjectProvider<MyService> myServiceObjectProvider;

    public void sayHello() {
        myService.hello();
        if (myServiceObjectProvider.getIfAvailable() != null) {
            MyService gamjaService = myServiceObjectProvider.getObject();
            gamjaService.hello();
        }
    }
}
