package com.fw.week7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.fw")
@PropertySource("classpath:gamja.properties")
public class AppConfig {
    @Value("${gamja.count}")
    public int count;

    @Bean
    public Gamja gamja() {
        return new Gamja(count);
    }

    @Bean
    public Transfer transfer(Gamja gamja) {
        return new Transfer(gamja);
    }
}
