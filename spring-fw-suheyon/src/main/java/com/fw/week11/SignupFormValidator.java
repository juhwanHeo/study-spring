package com.fw.week11;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SignupFormValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return SignupForm.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    // 이름은 필수이며, 공백만 입력할 수 없습니다.
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");

    // 나이는 필수이며, 14 이상이어야 합니다.
    if (errors.hasFieldErrors("age")) {
      return;
    }
    SignupForm form = (SignupForm) target;
    if (form.getAge() == null) {
      errors.rejectValue("age", "required");
    } else if (form.getAge() < 14) {
      errors.rejectValue("age", "min");
    }
  }
}
