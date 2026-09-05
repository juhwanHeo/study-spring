package com.fw.week8;


import com.fw.week7.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

@Slf4j
public class TransferRegistrar implements BeanRegistrar{

  @Override
  public void register(BeanRegistry registry, Environment environment) {
    registry.registerBean("Transfer", Transfer.class);
    log.info("{} 환경 입니다.", environment.getActiveProfiles()[0]);
  }
}
