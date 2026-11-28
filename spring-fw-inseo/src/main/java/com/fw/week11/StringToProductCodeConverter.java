package com.fw.week11;

import org.springframework.core.convert.converter.Converter;

import java.util.Locale;

public class StringToProductCodeConverter implements Converter<String, ProductCode> {

    @Override
    public ProductCode convert(String source) {

        // 1. 앞뒤 공백 제거
        String value = source.strip();

        // 2. 빈 문자열 거부
        if (value.isEmpty()) {
            throw new IllegalArgumentException("상품 코드는 비어 있을 수 없습니다.");
        }

        // 3. 실행 환경의 Locale에 영향받지 않는 대문자 변환
        return new ProductCode(value.toUpperCase(Locale.ROOT));
    }
}
