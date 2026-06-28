package com.fw;

import com.fw.week5.HelloService;
import com.fw.week6.AppConfig;
import com.fw.week7.Transfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.getEnvironment().setActiveProfiles("prod"); // prod로 바꾸면 prod 실행
    ctx.register(AppConfig.class);
    ctx.refresh();

    String potatoCount = ctx.getEnvironment().getProperty("potato.count");
    String message = ctx.getEnvironment().getProperty("env.message");

    System.out.println(message);
    System.out.println("감자 개수: " + potatoCount);

    ctx.close();
  }
}