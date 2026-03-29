package com.fw.week4;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Food {
    private String name;
    private String type;

    public Food() {}

    public Food(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // ── 1. Lifecycle Callbacks ──────────────────────────────
    @PostConstruct
    public void init() {
        System.out.println("  [Food] >>> @PostConstruct 호출됨 - 빈 초기화 완료: name=" + name + ", type=" + type);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("  [Food] >>> @PreDestroy 호출됨 - 빈 소멸 예정: name=" + name);
    }

    // ── Getters / Setters ───────────────────────────────────
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
