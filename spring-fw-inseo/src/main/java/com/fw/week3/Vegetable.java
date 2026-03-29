package com.fw.week3;

public class Vegetable {
    private String name;
    private String type;

    public Vegetable(String name, String type) {
        this.name = name;
        this.type = type;
        System.out.println("Vegetable 생성!");
    }

    public void print() {
        System.out.println("Vegetable: " + name + ", type: " + type);
    }
}