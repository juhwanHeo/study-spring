package com.fw.week8;

import com.fw.week7.Gamja;
import com.fw.week7.Transfer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(TransferRegistrar.class)
public class AppConfig {

  @Configuration
  @Profile("dev")
  @PropertySource("classpath:application-dev.properties")
  static class DevConfig {}

  @Configuration
  @Profile("prod")
  @PropertySource("classpath:application-prod.properties")
  static class ProdConfig {}

  @Value("${gamja.count}")
  private int count;

  @Bean
  public Gamja gamja() {
    return new Gamja(count);
  }
}
