package com.fw.week4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Week4Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  Spring IoC Container 시작");
        System.out.println("========================================");
        System.out.println(">>> 컨테이너 로딩 중... (빈 생성 + @PostConstruct 호출)");
        System.out.println("----------------------------------------\n");

        try (ClassPathXmlApplicationContext ctx =
                     new ClassPathXmlApplicationContext("week4.xml")) {

            // ── 1. Lifecycle Callbacks 확인 ──────────────────
            System.out.println("\n========================================");
            System.out.println("  [1] Lifecycle Callbacks 확인");
            System.out.println("========================================");
            System.out.println(">>> @PostConstruct 는 컨테이너 로딩 시 이미 호출됨 (위 로그 참고)");

            Food food = ctx.getBean("food4", Food.class);
            System.out.println("\n[확인] Food 빈 조회: " + food);

            Person person = ctx.getBean("sangjin4", Person.class);
            System.out.println("[확인] Person 빈 조회: " + person);
            person.hello();

            System.out.println("\n>>> @PreDestroy 는 컨테이너 종료 시 호출됩니다. (아래에서 확인)");

            // ── 2. Bean Definition Inheritance 확인 ──────────
            System.out.println("\n========================================");
            System.out.println("  [2] Bean Definition Inheritance 확인");
            System.out.println("========================================");
            System.out.println("  템플릿(personTemplate): name=홍길동, age=0");
            System.out.println("  자식(sangjin4):         age만 재정의");
            System.out.println("----------------------------------------");
            System.out.println("  name  (상속됨):  " + person.getName());
            System.out.println("  age   (재정의):  " + person.getAge());
            System.out.println("  gender (직접):   " + person.getGender());

            // ── 3. BeanPostProcessor 는 컨테이너 로딩 시 자동 출력됨 ──
            System.out.println("\n========================================");
            System.out.println("  [3] BeanPostProcessor 확인");
            System.out.println("========================================");
            System.out.println(">>> 컨테이너 로딩 시 Before/After Init 로그가 출력됨 (위 로그 참고)");

            System.out.println("\n----------------------------------------");
            System.out.println(">>> 컨테이너 종료 중... (@PreDestroy 호출)");
            System.out.println("----------------------------------------\n");

        } // try-with-resources → 컨텍스트 종료 → @PreDestroy 호출

        System.out.println("\n========================================");
        System.out.println("  Spring IoC Container 종료 완료");
        System.out.println("========================================");
    }
}
