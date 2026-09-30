package com.fw;

import com.fw.week10.ResourceService;
import java.nio.file.Path;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(ResourceService.class)) {
      ResourceService service = context.getBean(ResourceService.class);
      service.printResource(context.getResource("classpath:sample.txt"));

      // 실행 작업 디렉터리: spring-fw-juhwan
      String fileLocation = Path.of("spring-fw-juhwan/src/main/java/com/fw/week10/sample.txt")
          .toAbsolutePath().toUri().toString();
      service.printResource(context.getResource(fileLocation));
    }
  }
}
