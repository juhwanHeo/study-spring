package com.fw.week6;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("gamjaService")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.NO)
public class GamjaServiceImpl implements MyService {

    @Value("${gamja.count}")
    private int count;

    public GamjaServiceImpl() {
        // 생성자가 호출될 때마다 새 인스턴스가 만들어진다는 증거 로그
        System.out.println("  >> [GamjaServiceImpl] 새로운 인스턴스 생성! hashCode=" 
                + Integer.toHexString(System.identityHashCode(this)));
    }

    @Override
    public void hello() {
        System.out.println("  [GamjaServiceImpl] 강원도 감자 " + count 
                + "개 (인스턴스: " + Integer.toHexString(System.identityHashCode(this)) + ")");
    }
}
