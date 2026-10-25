package com.fw;

import com.fw.week10.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

  public static void main(String[] args) {

    try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ResourceService.class)) {

      ResourceService service = context.getBean(ResourceService.class);

      service.printResource(service.getResource("file:///C:/None/none.txt"));
      service.printResource(service.getResource("classpath:sample.txt"));
      service.printResource(service.getResource("file:///C:/Workspaces/study-spring/spring-fw-yiseoul/src/main/java/com/fw/week10/sample.txt"));
    }
  }
}