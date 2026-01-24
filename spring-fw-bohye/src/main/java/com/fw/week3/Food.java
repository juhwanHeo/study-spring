package com.fw.week3;

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
}
