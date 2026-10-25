package com.fw;

import com.fw.week10.AppConfig;
import com.fw.week10.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Path;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ResourceService resourceService = context.getBean(ResourceService.class);

            resourceService.printResource(context.getResource("classpath:sample.txt"));

            String fileLocation = Path.of("src/main/java/com/fw/week10/sample.txt")
                    .toAbsolutePath()
                    .toUri()
                    .toString();
            resourceService.printResource(context.getResource(fileLocation));

            resourceService.printResource(context.getResource("classpath:missing-sample.txt"));
        }
    }
}
