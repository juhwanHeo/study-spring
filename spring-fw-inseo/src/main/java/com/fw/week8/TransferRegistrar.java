package com.fw.week8;

import com.fw.week7.Gamja;
import com.fw.week7.Transfer;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class TransferRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {

        int gamjaCount =
                env.getProperty("gamja.count", Integer.class, 0);

        registry.registerBean("gamja", Gamja.class,
                spec -> spec.supplier(
                        context -> new Gamja(gamjaCount)
                ));

        registry.registerBean("transfer", Transfer.class,
                spec -> spec.supplier(
                        context -> new Transfer(
                                context.bean(Gamja.class)
                        )
                ));
    }
}