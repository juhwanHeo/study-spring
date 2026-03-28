package com.fw.week3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Food {
    private String name;
    private String type;

    public Food(String name, String type) {
        this.name = name;
        this.type = type;
        System.out.println("Food 생성!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Food @PostConstruct 실행");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Food @PreDestroy 실행");
    }

    // ✅ getter 추가
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void print() {
        System.out.println("Food: " + name + ", type: " + type);
    }
}