package com.fw.week5;

import org.springframework.stereotype.Service;

@Service("myServiceImpl")
public class MyServiceImpl implements MyService {

    @Override
    public void hello() {
        System.out.println("MyServiceImpl Hello");
    }
}