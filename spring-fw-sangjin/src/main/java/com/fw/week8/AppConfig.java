package com.fw.week8;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * Week 8 Java Config.
 *
 * - @PropertySource: 활성 프로파일(spring.profiles.active)에 맞는
 *   application-{profile}.properties 를 로드한다.
 *   (예: dev -> application-dev.properties, prod -> application-prod.properties)
 *   플레이스홀더 ${spring.profiles.active:dev} 는 시스템 프로퍼티/환경변수에
 *   spring.profiles.active 가 없을 경우 기본값 "dev" 를 사용한다.
 * - @Import(TransferRegistrar.class): BeanRegistrar 구현체를 설정에 반영한다.
 *   BeanRegistrar는 @Bean 처럼 동작하지 않고 설정 처리 시점에 인식되어야 하므로
 *   반드시 @Import 로 등록해야 한다.
 * - @ComponentScan: EnvironmentAnnouncer(@Component)를 스캔하기 위함.
 */
@Configuration
@ComponentScan(basePackages = "com.fw.week8")
@PropertySource("classpath:application-${spring.profiles.active:dev}.properties")
@Import(TransferRegistrar.class)
public class AppConfig {
}
