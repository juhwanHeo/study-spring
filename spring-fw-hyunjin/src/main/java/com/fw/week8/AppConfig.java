package com.fw.week8;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// @Import를 통해 TransferRegistrar를 설정 클래스에 결합시킵니다.
// 스프링이 구동될 때 이 Registrar 내부의 register() 메서드를 찾아 실행하게 됩니다.
@Import(TransferRegistrar.class)
public class AppConfig {
}