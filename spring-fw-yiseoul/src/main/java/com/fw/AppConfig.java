package com.fw;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.fw")
@PropertySource("classpath:gamja.properties")
public class AppConfig {

}
