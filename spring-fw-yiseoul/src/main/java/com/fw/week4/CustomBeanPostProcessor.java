package com.fw.week4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

@Slf4j
public class CustomBeanPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) {
    log.info(">> BeforeInitialization : 빈 이름 = {}", beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) {
    log.info("<< AfterInitialization  : 빈 이름 = {}", beanName);
    return bean;
  }
}
