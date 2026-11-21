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
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name.empty");

    if (errors.hasFieldErrors("age")) {
      return;
    }

    SignupForm form = (SignupForm) target;
    Integer age = form.getAge();
    if (age == null) {
      errors.rejectValue("age", "error.age.empty");
    } else if (age < 14) {
      errors.rejectValue("age", "error.age.invalid");
    }
  }
}
