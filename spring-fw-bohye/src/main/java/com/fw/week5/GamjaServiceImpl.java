package com.fw.week5;

import org.springframework.beans.factory.annotation.Value;

public class GamjaServiceImpl implements MyService {

    @Value("${gamja.count}")
    private int count;

    @Override
    public void hello() {
        System.out.println("감자는 총 " + count + "개이고 강원도에서 재배되어 로컬화폐로 사용됩니다.");
    }
}
