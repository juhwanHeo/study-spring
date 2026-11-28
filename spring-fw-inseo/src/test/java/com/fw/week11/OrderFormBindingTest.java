package com.fw.week11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.ConversionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.beans.TypeMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderFormBindingTest {

    private static AnnotationConfigApplicationContext context;
    private static ConversionService conversionService;

    @BeforeAll
    static void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        conversionService = context.getBean(ConversionService.class);
    }

    @AfterAll
    static void tearDown() {
        context.close();
    }

    @Test
    void bindsValidInput() {
        BindingResult result =
                Main.bindOrder(conversionService, " book-001 ", "2026/10/25");

        OrderForm form = (OrderForm) result.getTarget();
        assertNotNull(form);
        assertEquals(0, result.getErrorCount());
        assertEquals("BOOK-001", form.getProductCode().getValue());
        assertEquals(LocalDate.of(2026, 10, 25), form.getDeliveryDate());
        assertEquals("2026/10/25",
                conversionService.convert(form.getDeliveryDate(), String.class));
    }

    @Test
    void reportsTypeMismatchForBlankProductCode() {
        BindingResult result =
                Main.bindOrder(conversionService, " ", "2026/10/25");

        OrderForm form = (OrderForm) result.getTarget();
        assertNotNull(form);
        assertNull(form.getProductCode());
        assertEquals(LocalDate.of(2026, 10, 25), form.getDeliveryDate());
        assertEquals(1, result.getErrorCount());

        FieldError error = result.getFieldError("productCode");
        assertNotNull(error);
        assertEquals("typeMismatch", error.getCode());
        assertTrue(error.isBindingFailure());
        assertEquals(" ", error.getRejectedValue());
        assertTrue(error.unwrap(TypeMismatchException.class)
                .contains(IllegalArgumentException.class));
    }

    @Test
    void reportsTypeMismatchForNonExistentDate() {
        BindingResult result =
                Main.bindOrder(conversionService, "book-001", "2026/02/30");

        OrderForm form = (OrderForm) result.getTarget();
        assertNotNull(form);
        assertEquals("BOOK-001", form.getProductCode().getValue());
        assertNull(form.getDeliveryDate());
        assertEquals(1, result.getErrorCount());

        FieldError error = result.getFieldError("deliveryDate");
        assertNotNull(error);
        assertEquals("typeMismatch", error.getCode());
        assertTrue(error.isBindingFailure());
        assertEquals("2026/02/30", error.getRejectedValue());
        assertTrue(error.unwrap(TypeMismatchException.class)
                .contains(DateTimeParseException.class));
    }

    @Test
    void dataBinderPassesRawStringsToConverterAndFormatter() {
        List<String> convertedSources = new ArrayList<>();
        List<String> parsedTexts = new ArrayList<>();

        // 전달받은 값을 기록하는 Converter와 Formatter
        FormattingConversionService recordingService = new FormattingConversionService();
        recordingService.addConverter(new StringToProductCodeConverter() {
            @Override
            public ProductCode convert(String source) {
                convertedSources.add(source);
                return super.convert(source);
            }
        });
        recordingService.addFormatter(new LocalDateFormatter() {
            @Override
            public LocalDate parse(String text, Locale locale) {
                parsedTexts.add(text);
                return super.parse(text, locale);
            }
        });

        BindingResult result =
                Main.bindOrder(recordingService, " book-001 ", "2026/10/25");

        assertFalse(result.hasErrors());
        assertEquals(List.of(" book-001 "), convertedSources);
        assertEquals(List.of("2026/10/25"), parsedTexts);
    }
}
