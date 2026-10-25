package com.fw.week7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Gamja gamja() {
        return new Gamja(27);
    }

    @Bean
    public Transfer transfer(Gamja gamja) {
        return new Transfer(gamja);
    }
}