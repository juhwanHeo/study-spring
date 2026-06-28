package com.fw;

import com.fw.week8.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

    String activeProfile = "dev";
    context.getEnvironment().setActiveProfiles(activeProfile);

    context.register(AppConfig.class);
    context.refresh();
    
    Environment env = context.getEnvironment();
    
    System.out.println("===========================================");

    if ("dev".equals(activeProfile)) {
      System.out.println("개발환경입니다.");
      String gamjaCount = env.getProperty("dev.gamja.count", "0");
      System.out.println("감자 개수 (dev.gamja.count): " + gamjaCount);
    } else if ("prod".equals(activeProfile)) {
      System.out.println("운영환경입니다.");
      String gamjaCount = env.getProperty("prod.gamja.count", "0");
      System.out.println("감자 개수 (prod.gamja.count): " + gamjaCount);
    } else {
      System.out.println("기본 환경입니다.");
    }
    
    context.close();
  }
}