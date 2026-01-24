package com.fw.week3;

public enum VegetableType {
    ROOT("뿌리채소"),
    LEAF("잎채소"),
    FRUIT("열매채소"),
    ETC("기타");

    private final String name;

    VegetableType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
