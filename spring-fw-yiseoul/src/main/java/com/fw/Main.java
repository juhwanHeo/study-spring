package com.fw;

import com.fw.week8.AppConfig;
import com.fw.week7.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    String profile = "prod";
    context.getEnvironment().setActiveProfiles(profile);
    context.register(AppConfig.class);
    context.refresh();

    Transfer transfer = context.getBean(Transfer.class);
    transfer.transfer();

    context.close();
  }
}