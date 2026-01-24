package com.fw.week3;

// 무얼 해야할까?
// 1. 필드 선언 : 데이터 저장 공간
// 2. 기본 생성자
// 3. Setter 메서드 : 외부(XML)에서 들어온 값을 필드에 저장

public class Food {
    // 1. 필드 선언
    private String name; // name : 음식 이름
    private String type; // type : 음식 종류 (한식, 중식, 일식, 양식, ... ETC)

    // 2. 기본 생성자
    public Food() {}

    // 3. Setter 메서드 : 외부(XML)에서 들어온 값을 필드에 저장
    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }

}
