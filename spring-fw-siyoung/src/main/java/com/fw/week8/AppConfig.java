package com.fw.week8;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active:dev}.properties")
@Import(TransferRegistrar.class)
public class AppConfig {

}
