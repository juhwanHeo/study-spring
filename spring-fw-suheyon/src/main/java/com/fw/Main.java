package com.fw;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.fw.week10.ResourceService;

@Slf4j
public class Main {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
        ResourceService.class);
    ResourceService service = ctx.getBean(ResourceService.class);

    // classpath
    service.printResource(ctx.getResource("classpath:sample.txt"));

    // filepath
    service.printResource(ctx.getResource(
        "file:/C:/Users/Seeds/IdeaProjects/study-spring-week2/spring-fw-suheyon/src/main/java/com/fw/week10/sample.txt"
    ));

    ctx.close();
  }
}