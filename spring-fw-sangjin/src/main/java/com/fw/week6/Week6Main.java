package com.fw.week6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Week6Main {

    public static void main(String[] args) {

        System.out.println("Week6: Stereotype Annotation & Scope 실습");
        System.out.println("==========================================\n");

        // [STEP 1] AnnotationConfigApplicationContext 로드
        System.out.println("[STEP 1] AnnotationConfigApplicationContext 로드");
        System.out.println("  - 설정 클래스: AppConfig.class");
        System.out.println("  - @ComponentScan(basePackages = \"com.fw.week6\")");
        System.out.println("  - @PropertySource(\"classpath:gamja.properties\")\n");

        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            System.out.println("  => ApplicationContext 로드 완료!\n");

            // [STEP 2] 등록된 빈 목록 확인
            System.out.println("[STEP 2] 등록된 빈 목록 확인");
            String[] beanNames = ctx.getBeanDefinitionNames();
            for (int i = 0; i < beanNames.length; i++) {
                String scope = ctx.getBeanDefinition(beanNames[i]).getScope();
                if (scope.isEmpty()) scope = "singleton";
                System.out.printf("  [%d] %s (scope: %s)%n", i + 1, beanNames[i], scope);
            }
            System.out.printf("  => 총 %d개의 빈 등록됨%n%n", beanNames.length);

            // [STEP 3] @Service: MyServiceImpl 호출
            System.out.println("[STEP 3] @Service: MyServiceImpl 빈 호출");
            MyService myService = ctx.getBean("myService", MyService.class);
            System.out.print("  => ");
            myService.hello();
            System.out.println();

            // [STEP 4] @Scope("prototype"): GamjaServiceImpl 10번 호출
            System.out.println("[STEP 4] @Scope(\"prototype\"): GamjaServiceImpl 10번 호출");
            System.out.println("  - getBean() 호출마다 새로운 인스턴스가 생성됩니다.\n");

            for (int i = 1; i <= 10; i++) {
                System.out.printf("  [%2d회차] getBean(\"gamjaService\") 호출%n", i);
                MyService gamjaService = ctx.getBean("gamjaService", MyService.class);
                gamjaService.hello();
                System.out.println();
            }

            System.out.println("=> 결과: prototype 스코프이므로 10개의 서로 다른 인스턴스가 생성되었습니다.");
        }
    }
}
