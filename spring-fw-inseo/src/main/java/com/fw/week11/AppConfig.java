package com.fw.week11;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.support.FormattingConversionService;

@Configuration
@ComponentScan(basePackages = "com.fw.week11")
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("week11/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // 빈 이름을 conversionService로 지정하면 컨테이너 전체의 타입 변환에 사용되므로 구분
    @Bean
    public FormattingConversionService orderConversionService() {
        // 기본 Formatter가 등록되지 않은 ConversionService에 직접 구현한 것만 등록
        FormattingConversionService conversionService = new FormattingConversionService();
        conversionService.addConverter(new StringToProductCodeConverter());
        conversionService.addFormatter(new LocalDateFormatter());
        return conversionService;
    }
}
