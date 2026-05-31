package com.fw.week7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Gamja Gamja() {
    Gamja gamja = new Gamja();
    gamja.setCount(531);
    return gamja;
  }

  @Bean
  public Transfer Transfer(Gamja gamja) {
    return new Transfer(gamja);
  }
}
