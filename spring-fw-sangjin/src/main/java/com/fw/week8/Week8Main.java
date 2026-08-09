package com.fw.week8;

import com.fw.week7.Transfer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Week8Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("  Week8: BeanRegistrar & dev/prod Profile");
        System.out.println("==================================================\n");

        String[] profilesToRun = {"prod"}; //"prod"

        for (String profile : profilesToRun) {
            runWithProfile(profile);
        }
    }

    private static void runWithProfile(String profile) {
        System.out.println("--------------------------------------------------");
        System.out.println("[" + profile + "] 프로파일로 ApplicationContext 실행");
        System.out.println("--------------------------------------------------");

        // application-${spring.profiles.active}.properties 를 로드하기 위한
        // 플레이스홀더 값. VM Option 없이 코드에서 직접 System 프로퍼티로 설정한다.
        // AnnotationConfigApplicationContext 생성(=refresh) 이전에 설정해야
        // @PropertySource 플레이스홀더와 Environment.getActiveProfiles() 양쪽에
        // 모두 반영된다.
        System.setProperty("spring.profiles.active", profile);

        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            // TransferRegistrar(BeanRegistrar)가 등록한 transfer 빈 조회
            Transfer transfer = ctx.getBean("transfer", Transfer.class);
            transfer.transfer();
            System.out.println();
        }
    }
}
