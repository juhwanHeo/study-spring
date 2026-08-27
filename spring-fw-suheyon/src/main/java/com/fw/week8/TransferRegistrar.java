package com.fw.week8;

import com.fw.week7.Gamja;
import com.fw.week7.Transfer;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class TransferRegistrar implements BeanRegistrar {

  @Override
  public void register(BeanRegistry registry, Environment env) {
    int count = env.getProperty("potato.count", Integer.class);

    registry.registerBean(Gamja.class, spec -> spec
        .supplier(context -> new Gamja(count)));

    registry.registerBean(Transfer.class, spec -> spec
        .supplier(context -> new Transfer(context.bean(Gamja.class))));
  }
}