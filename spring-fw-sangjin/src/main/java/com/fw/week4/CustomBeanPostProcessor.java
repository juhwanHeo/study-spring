package com.fw.week4;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    // ── 3. BeanPostProcessor ────────────────────────────────

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor] Before Init - 빈 이름: " + beanName +
                " / 타입: " + bean.getClass().getSimpleName());
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[BeanPostProcessor] After  Init - 빈 이름: " + beanName +
                " / 타입: " + bean.getClass().getSimpleName());
        return bean;
    }
}
