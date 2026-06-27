package com.fw.week8;

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
}