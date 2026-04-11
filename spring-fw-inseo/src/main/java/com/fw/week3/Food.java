package com.fw.week3;

public class Food {
    private String name;
    private String type;

    public Food(String name, String type) {
        this.name = name;
        this.type = type;
        System.out.println("Food 생성!");
    }

    public void print() {
        System.out.println("Food: " + name + ", type: " + type);
    }
}