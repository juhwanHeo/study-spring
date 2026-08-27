package com.fw.week8;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Week 8: 애플리케이션(ApplicationContext) 로딩 시점에 현재 활성화된
 * 운영 환경(profile)이 무엇인지 출력하는 컴포넌트.
 *
 * ApplicationContext 가 초기화되어 빈이 생성되는 시점(@PostConstruct)에
 * Environment 로부터 활성 프로파일을 조회하여 콘솔에 출력한다.
 */
@Component
public class EnvironmentAnnouncer {

    private final Environment env;

    public EnvironmentAnnouncer(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void announce() {
        String[] activeProfiles = env.getActiveProfiles();
        String profile = activeProfiles.length > 0 ? activeProfiles[0] : "dev";

        switch (profile) {
            case "prod" -> System.out.println("prod: production running.");
            case "dev" -> System.out.println("dev: 개발환경입니다.");
            default -> System.out.println(profile + ": 알 수 없는 환경입니다.");
        }
    }
}
