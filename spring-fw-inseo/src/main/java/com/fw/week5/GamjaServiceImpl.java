package com.fw.week5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gamjaServiceImpl")
public class GamjaServiceImpl implements MyService {

    @Value("${gamja.count}")
    private int count;

    @Override
    public void hello() {
        System.out.println("GamjaServiceImpl Hello");
        System.out.println("GamjaServiceImpl gamja count: " + count);
    }
}