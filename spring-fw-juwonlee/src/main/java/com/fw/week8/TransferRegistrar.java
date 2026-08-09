package com.fw.week8;

import com.fw.week7.Gamja;
import com.fw.week7.Transfer;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class TransferRegistrar implements BeanRegistrar {
    @Override
    public void register(BeanRegistry registry, Environment env) {
        /**
         * BeanRegistrar.register() 메소드는 @Bean 메소드보다 먼저 실행됨
         * Transfer에서 Gamja 의존성을 주입받아야 하므로 우선 Bean 등록 진행
         */
        registry.registerBean(Gamja.class, spec ->
                spec.supplier(context -> {
                    int count = Integer.parseInt(env.getProperty("gamja.count", "0"));
                    return new Gamja(count);
                })
        );

        /**
         * Transfer 생성자에서 Gamja를 의존성으로 주입받으므로, 위에 등록된 Gamja Bean을 가져옴
         */
        registry.registerBean(Transfer.class, spec ->
                spec.supplier(context -> new Transfer(context.bean(Gamja.class)))
        );
    }
}
