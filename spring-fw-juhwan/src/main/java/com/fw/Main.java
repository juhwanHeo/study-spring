package com.fw;

import com.fw.week8.AppConfig;
import com.fw.week7.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
public class Main {

  public static void main(String[] args) {
    ApplicationContext context =
        new AnnotationConfigApplicationContext(AppConfig.class);
//    Transfer transfer = context.getBean(Transfer.class);
//    transfer.transfer();

    Environment env = context.getEnvironment();
    log.info("{} 환경입니다.", env.getActiveProfiles()[0]);
    log.info("gamja {} 개", env.getProperty("gamja.count", "0"));

  }
}