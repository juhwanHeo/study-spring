package com.fw.week10;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            ResourceService resourceService =
                    context.getBean(ResourceService.class);

            // 1. Classpath Resource
            resourceService.printResource(
                    context.getResource("classpath:sample.txt")
            );

            // 2. File System Resource
            String fileLocation = Path.of(
                    "src/main/java/com/fw/week10/sample.txt"
            ).toAbsolutePath().toUri().toString();

            resourceService.printResource(
                    context.getResource(fileLocation)
            );

            // 3. 존재하지 않는 Resource
            resourceService.printResource(
                    context.getResource("classpath:missing.txt")
            );
        }
    }
}
