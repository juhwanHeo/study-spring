package com.fw.week8;

import com.fw.week7.Gamja;
import com.fw.week7.Transfer;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

/**
 * Week 8: BeanRegistrar 를 사용한 프로그래밍 방식(programmatic) 빈 등록 예제.
 *
 * Spring Framework 7부터 제공되는 {@link BeanRegistrar} 인터페이스는
 * {@code @Bean} 메서드 대신 코드로 직접 빈을 등록할 수 있게 해준다.
 * BeanRegistrar 구현체는 {@link BeanRegistry}(빈 등록 API)와
 * {@link Environment}(프로퍼티/프로파일 조회 API)에 동시에 접근할 수 있어서,
 * "현재 활성화된 프로파일이나 프로퍼티 값에 따라 다른 빈을 등록"하는 것과 같은
 * 동적 빈 등록 시나리오에 적합하다.
 *
 * 여기서는 gamja.count 프로퍼티 값(dev=100, prod=1)을 읽어
 * week7의 Gamja/Transfer 클래스를 그대로 재사용하여 빈을 등록한다.
 *
 * 주의: BeanRegistrar는 @Bean 메서드처럼 동작하지 않으며,
 * 설정 처리 시점에 발견되어야 하므로 반드시 @Import 로 등록해야 한다.
 */
public class TransferRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {

        int gamjaCount = env.getProperty("gamja.count", Integer.class, 0);

        registry.registerBean("gamja", Gamja.class, spec -> spec
                .description("gamja.count 프로퍼티(" + gamjaCount + "개)로 생성된 Gamja 빈")
                .supplier(context -> new Gamja(gamjaCount)));

        registry.registerBean("transfer", Transfer.class, spec -> spec
                .description("Gamja 를 주입받는 Transfer 빈")
                .supplier(context -> new Transfer(context.bean(Gamja.class))));
    }
}
