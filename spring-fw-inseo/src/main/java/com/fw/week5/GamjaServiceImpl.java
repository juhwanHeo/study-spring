package com.fw.week5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("gamjaServiceImpl")
@Scope("prototype")
public class GamjaServiceImpl implements MyService {

    @Value("${gamja.count}")
    private int count;

    public GamjaServiceImpl() {
        System.out.println("GamjaServiceImpl 새 빈 생성");
    }

    @Override
    public void hello() {
        System.out.println("GamjaServiceImpl gamja count: " + count);
    }
}