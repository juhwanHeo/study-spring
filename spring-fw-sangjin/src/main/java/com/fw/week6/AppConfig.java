package com.fw.week6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Week 6 Java Config
 *
 * @Service Annotation을 사용하기 위한 사전 작업:
 *   - @ComponentScan: 지정된 패키지 하위의 @Component, @Service, @Repository, @Controller
 *                     어노테이션이 붙은 클래스들을 자동으로 빈으로 등록한다.
 *   - @PropertySource: GamjaServiceImpl의 @Value("${gamja.count}")가 동작하도록 properties 로드.
 */
@Configuration
@ComponentScan(basePackages = "com.fw.week6")
@PropertySource("classpath:gamja.properties")
public class AppConfig {
}
