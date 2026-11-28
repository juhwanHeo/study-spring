package com.fw.week11;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SignupFormBindingTest {

    private static AnnotationConfigApplicationContext context;
    private static SignupFormValidator validator;
    private static MessageSource messageSource;

    @BeforeAll
    static void setUp() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        validator = context.getBean(SignupFormValidator.class);
        messageSource = context.getBean(MessageSource.class);
    }

    @AfterAll
    static void tearDown() {
        context.close();
    }

    @Test
    void supportsOnlySignupForm() {
        assertTrue(validator.supports(SignupForm.class));
        assertFalse(validator.supports(String.class));
    }

    @Test
    void bindsValidInput() {
        BindingResult result = Main.bind(validator, "홍길동", "20");

        SignupForm form = (SignupForm) result.getTarget();
        assertNotNull(form);
        assertEquals("홍길동", form.getName());
        assertEquals(20, form.getAge());
        assertEquals(0, result.getErrorCount());
    }

    @Test
    void rejectsBlankNameAndUnderage() {
        BindingResult result = Main.bind(validator, " ", "13");

        assertEquals(2, result.getErrorCount());

        FieldError nameError = result.getFieldError("name");
        assertNotNull(nameError);
        assertFalse(nameError.isBindingFailure());
        assertArrayEquals(new String[]{
                "required.signupForm.name",
                "required.name",
                "required.java.lang.String",
                "required"
        }, nameError.getCodes());
        assertEquals("이름은 필수이며 공백만 입력할 수 없습니다.", message(nameError));

        FieldError ageError = result.getFieldError("age");
        assertNotNull(ageError);
        assertFalse(ageError.isBindingFailure());
        assertArrayEquals(new String[]{
                "min.signupForm.age",
                "min.age",
                "min.java.lang.Integer",
                "min"
        }, ageError.getCodes());
        assertEquals("나이는 14세 이상이어야 합니다.", message(ageError));
    }

    @Test
    void registersOnlyTypeMismatchWhenAgeIsNotNumber() {
        BindingResult result = Main.bind(validator, "홍길동", "abc");

        SignupForm form = (SignupForm) result.getTarget();
        assertNotNull(form);
        assertEquals("홍길동", form.getName());
        assertNull(form.getAge());

        // 필수값(required) 오류가 중복 등록되지 않아야 함
        assertEquals(1, result.getErrorCount());

        FieldError ageError = result.getFieldError("age");
        assertNotNull(ageError);
        assertTrue(ageError.isBindingFailure());
        assertEquals("abc", ageError.getRejectedValue());
        assertArrayEquals(new String[]{
                "typeMismatch.signupForm.age",
                "typeMismatch.age",
                "typeMismatch.java.lang.Integer",
                "typeMismatch"
        }, ageError.getCodes());
        assertEquals("나이는 숫자로 입력해야 합니다.", message(ageError));
    }

    @Test
    void validatesNameEvenWhenAgeBindingFails() {
        BindingResult result = Main.bind(validator, " ", "abc");

        assertEquals(2, result.getErrorCount());
        assertEquals("required", result.getFieldError("name").getCode());
        assertEquals("typeMismatch", result.getFieldError("age").getCode());
    }

    @Test
    void acceptsMinimumAge() {
        BindingResult result = Main.bind(validator, "홍길동", "14");

        assertFalse(result.hasErrors());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    void rejectsEmptyAgeAsRequired(String age) {
        BindingResult result = Main.bind(validator, "홍길동", age);

        assertEquals(1, result.getErrorCount());

        FieldError ageError = result.getFieldError("age");
        assertNotNull(ageError);
        assertEquals("required", ageError.getCode());
        assertEquals("나이는 필수입니다.", message(ageError));
    }

    @Test
    void rejectsMissingValues() {
        BindingResult result = Main.bind(validator, null, null);

        assertEquals(2, result.getErrorCount());
        assertEquals("required", result.getFieldError("name").getCode());
        assertEquals("required", result.getFieldError("age").getCode());
    }

    private static String message(FieldError error) {
        return messageSource.getMessage(error, Locale.KOREA);
    }
}
