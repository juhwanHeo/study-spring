package com.fw.week3;

// 1. 필요한 import 추가
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Vegetable{
    // 로거 선언 (필요하다면 사용, 클래스 수준에서 관리)
    private static final Logger log = LoggerFactory.getLogger(Vegetable.class);

    // 필드 선언 (데이터 보관함)
    private String name; // name: 채소 이름
    private String type; // 분류(뿌리채소, 잎채소, 열매채소)

    // 기본 생성자 (*Spring 빈 생성 위해 필수)
    public Vegetable() {
        System.out.println("Vegetable 기본 생성자 생성완료!");
    }
    // 3. Getter
    public String getName() { return name; }
    public String getType() { return type; }

    // 4. Setter (Spring XML 주입을 위해 필수)
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }

    // 5. 출력 메서드 (System.out.println 사용)
    public void print() {
        System.out.println("--------------------");
        System.out.println("채소 정보 출력");
        System.out.println("분류 : " + type);
        System.out.println("이름 : " + name);
        System.out.println("--------------------");
    }

    // 6. toString 오버라이드 (객체 주소값 대신 내용을 보기 위해)
    @Override
    public String toString() {
        return name + "[" + type + "]";
    }

}