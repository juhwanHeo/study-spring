package com.fw.week10;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Week 10 Java Config.
 *
 * ResourceService 는 @Service 로 선언되어 있으므로 @ComponentScan 으로 등록한다.
 */
@Configuration
@ComponentScan(basePackages = "com.fw.week10")
public class AppConfig {
}
