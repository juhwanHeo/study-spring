package com.fw;

import com.fw.week7.Transfer;
import com.fw.week8.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        run("dev");
        run("prod");
    }

    private static void run(String profile) {
        System.setProperty("spring.profiles.active", profile);

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            String activeProfile = context.getEnvironment()
                    .getProperty("spring.profiles.active", "dev");

            if ("dev".equals(activeProfile)) {
                System.out.println("dev: 개발환경입니다.");
            } else if ("prod".equals(activeProfile)) {
                System.out.println("prod: production running.");
            }

            Transfer transfer = context.getBean("transfer", Transfer.class);
            transfer.transfer();
        }

        System.out.println();
    }
}