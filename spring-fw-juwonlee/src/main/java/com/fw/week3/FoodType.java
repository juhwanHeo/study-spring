package com.fw.week3;

public enum FoodType {
    KOREAN("한식"),
    JAPANESE("일식"),
    CHINESE("중식"),
    WESTERN("양식"),
    ETC("기타");

    private final String name;

    FoodType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
