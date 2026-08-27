package com.fw;

import com.fw.week8.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Environment env = context.getEnvironment();
        log.info("Current Profile: {}", env.getActiveProfiles()[0]);
        log.info("gamja count: {}", env.getProperty("gamja.count", "0"));

        context.close();
    }
}
