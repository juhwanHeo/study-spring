package com.fw.week3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Food {
    private String name;
    private FoodType type;

    @PostConstruct
    public void init() {
        log.info("Food PostConstruct called.");
    }

    @PreDestroy
    public void destroy() {
        log.info("Food PreDestroy called.");
    }
}
