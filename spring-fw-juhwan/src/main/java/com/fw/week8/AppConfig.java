package com.fw.week8;

import com.fw.week7.Gamja;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({TransferRegistrar.class})
@PropertySource("classpath:gamja.properties")
public class AppConfig {

  @Value("${gamja.count}")
  private int count;

  @Bean
  public Gamja gamja() {
    return new Gamja(count);
  }
}
