package com.fw;

import com.fw.week2.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;

@Slf4j
public class Main {

  public static void main(String[] args) {
      try (ClassPathXmlApplicationContext ctx =
                   new ClassPathXmlApplicationContext("week2.xml")) {

          Person me = ctx.getBean("sangjin", Person.class);

          System.out.println(me); // PR 첨부용 전체 출력
          me.hello();             // 자기소개 출력
      }
  }
}