package com.fw.week11;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class AppConfig {

  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("week11/messages"); // src/main/resources/week11/messages.properties
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
