package com.fw.week11;

import org.springframework.format.Formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {

    // STRICT: 존재하지 않는 날짜를 보정하지 않고 거부
    // uuuu: STRICT에서는 yyyy(year-of-era)만으로 날짜를 만들 수 없음
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("uuuu/MM/dd")
                    .withResolverStyle(ResolverStyle.STRICT);

    // 숫자로만 구성된 고정 형식이므로 locale은 사용하지 않음
    @Override
    public LocalDate parse(String text, Locale locale) {
        return LocalDate.parse(text, DATE_FORMAT);
    }

    @Override
    public String print(LocalDate date, Locale locale) {
        return DATE_FORMAT.format(date);
    }
}
