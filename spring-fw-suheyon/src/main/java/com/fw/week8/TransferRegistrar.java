package com.fw.week8;

import org.springframework.context.annotation.BeanRegistrar;
import org.springframework.context.annotation.BeanRegistry;
import org.springframework.core.env.Environment;

public class TransferRegistrar implements BeanRegistrar {

  @Override
  public void register(BeanRegistry registry, Environment env) {
    registry.registerBean("transferService", TransferService.class);
  }
}