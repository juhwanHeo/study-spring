package com.fw.week8;

import com.fw.week7.Gamja;
import com.fw.week7.Transfer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:gamja.properties")
@Import(TransferRegistrar.class)
public class AppConfig {

  @Value("${gamja.count}")
  private int count;

  @Bean
  public Gamja gamja() {
    return new Gamja(count);
  }
}
