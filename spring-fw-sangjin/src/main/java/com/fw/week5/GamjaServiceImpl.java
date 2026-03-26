package com.fw.week5;

import org.springframework.beans.factory.annotation.Value;

public class GamjaServiceImpl implements MyService {

    @Value("${gamja.count}")
    private int count;

    @Override
    public void hello() {
        System.out.println("[GamjaServiceImpl] 강원도에서 재배한 감자 " + count + "개가 있습니다");
    }
}
