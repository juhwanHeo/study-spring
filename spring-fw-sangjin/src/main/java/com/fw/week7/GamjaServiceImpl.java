package com.fw.week7;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("gamjaService")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.NO)
public class GamjaServiceImpl implements MyService {

    public GamjaServiceImpl() {
        System.out.println("  >> [GamjaServiceImpl] 새로운 인스턴스 생성! hashCode="
                + Integer.toHexString(System.identityHashCode(this)));
    }

    @Override
    public void hello() {
        System.out.println("  [GamjaServiceImpl] hello() 호출 - 인스턴스: "
                + Integer.toHexString(System.identityHashCode(this)));
    }
}
