package com.fw.week7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.fw.week7")
public class AppConfig {

    @Bean
    public Gamja gamja() {
        return new Gamja(100);
    }

    @Bean
    public Transfer transfer() {
        return new Transfer(gamja());
    }
}
