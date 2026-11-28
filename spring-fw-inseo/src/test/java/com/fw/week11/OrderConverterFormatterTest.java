package com.fw.week11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderConverterFormatterTest {

    private final StringToProductCodeConverter converter = new StringToProductCodeConverter();
    private final LocalDateFormatter formatter = new LocalDateFormatter();

    @Test
    void stripsAndUppercasesProductCode() {
        assertEquals("BOOK-001", converter.convert(" book-001 ").getValue());
    }

    @Test
    void uppercasesIndependentlyOfDefaultLocale() {
        Locale original = Locale.getDefault();

        try {
            // 터키어 Locale에서는 i의 대문자가 İ이므로 Locale.ROOT 사용 여부를 확인할 수 있음
            Locale.setDefault(Locale.forLanguageTag("tr-TR"));

            assertEquals("ITEM-001", converter.convert("item-001").getValue());
        } finally {
            Locale.setDefault(original);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", " \t\n "})
    void rejectsBlankProductCode(String source) {
        assertThrows(IllegalArgumentException.class,
                () -> converter.convert(source));
    }

    @ParameterizedTest
    @ValueSource(strings = {"2026/10/25", "2028/02/29"})
    void parsesAndPrintsExistingDate(String text) {
        LocalDate date = formatter.parse(text, Locale.KOREA);

        assertEquals(text, formatter.print(date, Locale.KOREA));
    }

    @Test
    void parsesDateFields() {
        assertEquals(LocalDate.of(2026, 10, 25),
                formatter.parse("2026/10/25", Locale.KOREA));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2026/02/30",
            "2026/02/29",
            "2026/04/31",
            "2026/13/01",
            "2026-10-25",
            "2026/1/5"
    })
    void rejectsInvalidDate(String text) {
        assertThrows(DateTimeParseException.class,
                () -> formatter.parse(text, Locale.KOREA));
    }
}
