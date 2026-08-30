package com.fw.week7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Gamja gamja() {
    return new Gamja(6);
  }

  @Bean
  public Transfer transfer() {
    return new Transfer(gamja());
  }
}