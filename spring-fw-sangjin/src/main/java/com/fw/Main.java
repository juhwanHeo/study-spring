package com.fw;

import com.fw.week2.Person;
import com.fw.week3.Vegetable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;

@Slf4j
public class Main {

  public static void main(String[] args) {
      try (ClassPathXmlApplicationContext ctx =
                   new ClassPathXmlApplicationContext("week3.xml")) {

          // Person 빈 조회
          Person me = ctx.getBean("sangjin", Person.class);
          System.out.println(me);
          me.hello();

          System.out.println("\n=== Vegetable 빈 조회 시도 ===");
          // Vegetable 빈 조회
          Vegetable vegetable = ctx.getBean("vegetable", Vegetable.class);
          System.out.println(vegetable);
      }
  }
}