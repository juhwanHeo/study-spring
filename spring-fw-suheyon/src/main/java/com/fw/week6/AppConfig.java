package com.fw.week6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.fw")
@PropertySource("classpath:gamja.properties")
public class AppConfig {

}
