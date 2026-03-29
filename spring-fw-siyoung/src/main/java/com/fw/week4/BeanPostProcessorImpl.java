package com.fw.week4;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImpl implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) {
    System.out.printf("[Before] %s Bean 감지됨. %n", beanName);
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) {
    System.out.printf("[After] %s Bean 감지됨. %n", beanName);
    return bean;
  }
}
