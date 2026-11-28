package com.fw.week11;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SignupFormValidator implements Validator {

    private static final int MIN_AGE = 14;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignupForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        // 1. 이름: 필수값, 공백만 입력 불가
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");

        // 2. 나이: 바인딩(타입 변환)에 실패한 경우에는 검증하지 않음
        //    변환 실패 시 age는 null이므로, 그대로 검증하면 필수값 오류가 중복 등록됨
        if (errors.hasFieldErrors("age")) {
            return;
        }

        SignupForm form = (SignupForm) target;

        // 3. 나이: 필수값, 14 이상
        if (form.getAge() == null) {
            errors.rejectValue("age", "required");
        } else if (form.getAge() < MIN_AGE) {
            errors.rejectValue("age", "min", new Object[]{MIN_AGE}, null);
        }
    }
}
