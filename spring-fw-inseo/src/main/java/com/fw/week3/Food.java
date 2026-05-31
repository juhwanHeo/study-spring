package com.fw.week3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Food {
    private String name;
    private String type;

    public Food() {
        System.out.println("Food 기본 생성!");
    }

    public Food(String name, String type) {
        this.name = name;
        this.type = type;
        System.out.println("Food 생성!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @PostConstruct
    public void init() {
        System.out.println("Food 빈 생성 완료");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Food 빈 소멸");
    }

    public void print() {
        System.out.println("Food: " + name + ", type: " + type);
    }
}