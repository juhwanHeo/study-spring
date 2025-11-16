package com.fw.week2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // resource/week2.xml 설정 파일을 읽어서 컨테이너 생성
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("week2.xml");

        // bean id가 'juhwan'인 Person 객체를 가져오기
        Person me = (Person) ctx.getBean("juhwan");

        // 자기소개 출력
        me.hello();

        ctx.close();
    }
}
