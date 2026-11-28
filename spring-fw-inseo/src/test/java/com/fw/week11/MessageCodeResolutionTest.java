package com.fw.week11;

import org.junit.jupiter.api.Test;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.StaticMessageSource;
import org.springframework.validation.FieldError;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MessageCodeResolutionTest {

    private final SignupFormValidator validator = new SignupFormValidator();

    @Test
    void prefersMoreSpecificMessageCode() {
        FieldError error = ageError("13");
        StaticMessageSource messageSource = new StaticMessageSource();

        // 일반적인 코드부터 하나씩 등록하면, 새로 등록한 더 구체적인 코드가 선택되어야 함
        String[] codesFromGeneralToSpecific = {
                "min",
                "min.java.lang.Integer",
                "min.age",
                "min.signupForm.age"
        };

        for (String code : codesFromGeneralToSpecific) {
            messageSource.addMessage(code, Locale.KOREA, code + " 메시지");

            assertEquals(code + " 메시지",
                    messageSource.getMessage(error, Locale.KOREA));
        }
    }

    @Test
    void fallsBackToDefaultMessageWhenNoCodeIsDefined() {
        // 바인딩 오류에는 DataBinder가 기본 메시지를 함께 등록함
        FieldError error = ageError("abc");
        StaticMessageSource messageSource = new StaticMessageSource();

        assertNotNull(error.getDefaultMessage());
        assertEquals(error.getDefaultMessage(),
                messageSource.getMessage(error, Locale.KOREA));
    }

    @Test
    void throwsWhenNeitherCodeNorDefaultMessageExists() {
        // Validator에서 기본 메시지 없이 등록한 오류
        FieldError error = ageError("13");
        StaticMessageSource messageSource = new StaticMessageSource();

        assertNull(error.getDefaultMessage());
        assertThrows(NoSuchMessageException.class,
                () -> messageSource.getMessage(error, Locale.KOREA));
    }

    private FieldError ageError(String age) {
        FieldError error = Main.bind(validator, "홍길동", age).getFieldError("age");
        assertNotNull(error);
        return error;
    }
}
