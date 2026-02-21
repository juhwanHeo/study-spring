package com.fw.week3;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Vegetable {
    private String name;
    private String type;

    public void yummy() {
        log.info("name: {}", name);
        log.info("type: {}", type);
    }
}