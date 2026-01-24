package com.fw.week3;

public class Food {
    private String name; // 음식 이름
    private String type; // 음식 종류 (한식, 중식, 일식, 양식, ... ETC)

    public Food() {}

    public Food(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
