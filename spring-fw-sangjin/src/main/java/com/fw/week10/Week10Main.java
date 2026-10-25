package com.fw.week10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Week10Main {

    private static final String PROJECT_DIR =
            "C:/Users/sangj/IdeaProjects/study-spring/spring-fw-sangjin";

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            ResourceService resourceService = ctx.getBean(ResourceService.class);

            // [STEP 1] 클래스패스 리소스 (src/main/resources/sample.txt)
            read(resourceService, "STEP 1", "classpath:sample.txt");

            // [STEP 2] 파일 시스템 리소스 (절대 경로)
            read(resourceService, "STEP 2",
                    "file:///" + PROJECT_DIR + "/src/main/java/com/fw/week10/sample.txt");

            // [STEP 3] 존재하지 않는 클래스패스 리소스
            // src/main/java 아래의 .txt 는 Gradle 이 클래스패스(build/resources)로 복사하지 않는다.
            read(resourceService, "STEP 3", "classpath:com/fw/week10/sample.txt");

            // [STEP 4] 존재하지 않는 파일 시스템 리소스
            read(resourceService, "STEP 4",
                    "file:///" + PROJECT_DIR + "/src/main/java/com/fw/week10/not-exist.txt");
        }
    }

    private static void read(ResourceService resourceService, String step, String location) {
        log.info("");
        log.info("[{}] location = {}", step, location);
        try {
            resourceService.printResource(location);
        } catch (ResourceService.ResourceNotFoundException e) {
            log.error("    예외 발생   : {}", e.getClass().getSimpleName());
            log.error("    메시지      : {}", e.getMessage());
        }
    }
}
