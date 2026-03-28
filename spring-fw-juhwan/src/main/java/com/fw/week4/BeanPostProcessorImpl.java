package com.fw.week4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class BeanPostProcessorImpl implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    log.info(">>> postProcessBeforeInitialization beanName={}", beanName);
    return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    log.info(">>> postProcessAfterInitialization beanName={}", beanName);
    return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
  }
}
