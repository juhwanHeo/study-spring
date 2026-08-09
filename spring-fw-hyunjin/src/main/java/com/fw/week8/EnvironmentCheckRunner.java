package com.fw.week8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EnvironmentCheckRunner implements CommandLineRunner {

    private final Environment environment;

    // 프로퍼티 파일에 정의된 감자 개수를 주입받습니다.
    @Value("${gamja.count}")
    private int gamjaCount;

    // 현재 구동 환경(Profile) 정보를 알기 위해 Environment 객체를 주입받습니다.
    public EnvironmentCheckRunner(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(String... args) throws Exception {
        // 현재 활성화된 프로파일 배열을 가져옵니다.
        String[] activeProfiles = environment.getActiveProfiles();

        // 배열을 리스트로 변환하여 특정 프로파일이 포함되어 있는지 검사합니다.
        var profilesList = Arrays.asList(activeProfiles);

        if (profilesList.contains("dev")) {
            System.out.println("dev: 개발환경입니다.");
            System.out.println("현재 감자 개수: " + gamjaCount + "개");
        } else if (profilesList.contains("prod")) {
            System.out.println("prod: production running.");
            System.out.println("현재 감자 개수: " + gamjaCount + "개");
        } else {
            System.out.println("현재 기본 환경으로 실행 중입니다. (Active Profile 없음)");
        }
    }
}