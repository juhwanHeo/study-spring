package com.fw.week8;


import com.fw.week7.Transfer;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

public class TransferRegistrar implements BeanRegistrar{

  @Override
  public void register(BeanRegistry registry, Environment environment) {
    registry.registerBean("Transfer", Transfer.class);
  }
}
