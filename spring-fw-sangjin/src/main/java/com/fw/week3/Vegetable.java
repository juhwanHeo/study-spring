package com.fw.week3;

public class Vegetable {
    private String name; // 채소 이름
    private String type; // 분류(뿌리채소, 잎채소, 열매채소)

    public Vegetable() {
        System.out.println("Vegetable 빈 생성");
    }

    public Vegetable(String name, String type) {
        this.name = name;
        this.type = type;
        System.out.println("Vegetable 빈 생성");
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
        return "Vegetable{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
