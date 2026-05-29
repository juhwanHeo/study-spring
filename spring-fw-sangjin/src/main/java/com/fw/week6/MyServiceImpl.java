package com.fw.week6;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceImpl implements MyService {

    @Override
    public void hello() {
        System.out.println("[MyServiceImpl] 안녕하세요! 저는 MyServiceImpl 입니다.");
    }
}
