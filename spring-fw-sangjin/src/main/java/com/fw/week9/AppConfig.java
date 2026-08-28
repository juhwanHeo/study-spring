package com.fw.week9;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Week 9 Java Config.
 *
 * OrderPublisher, OrderConsumer 는 각각 @Component 로 선언되어 있으므로
 * @ComponentScan 으로 빈 등록과 @EventListener 등록을 함께 처리한다.
 */
@Configuration
@ComponentScan(basePackages = "com.fw.week9")
public class AppConfig {
}
