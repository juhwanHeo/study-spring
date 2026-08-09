package com.fw.week8;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.BeanRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class TransferRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanDefinitionRegistry registry, AnnotationMetadata importingClassMetadata) {
        // 1. 등록할 클래스의 명세서(BeanDefinition)를 빌더를 통해 생성합니다.
        // 임의로 'TransferService'라는 클래스가 있다고 가정하고 등록하는 예시입니다.
        var beanDefinition = BeanDefinitionBuilder
                .genericBeanDefinition(TransferService.class)
                .getBeanDefinition();

        // 2. 스프링 빈 컨테이너(Registry)에 "transferService"라는 이름으로 명세서를 등록합니다.
        registry.registerBeanDefinition("transferService", beanDefinition);
    }
}