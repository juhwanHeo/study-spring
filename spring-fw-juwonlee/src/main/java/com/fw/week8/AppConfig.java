package com.fw.week8;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active:dev}.properties")
@Import(TransferRegistrar.class)
public class AppConfig {
}
