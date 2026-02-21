package com.fw.week3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Food {
    private String name;
    private String type;

    public Food() {
        log.info("Food created (constructor called).");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Food @PostConstruct called. bean initialized.");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Food @PreDestroy called. bean will be destroyed.");
    }
}
