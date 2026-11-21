package com.fw.week11;

import java.util.Arrays;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;

@Slf4j
public class SignupFormExample {

  public static void run() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("week11/messages");
    messageSource.setDefaultEncoding("UTF-8");

    runExample("Valid input", "홍길동", "20", messageSource);
    runExample("Validation failure", " ", "13", messageSource);
    runExample("Type conversion failure", "홍길동", "abc", messageSource);
  }

  private static void runExample(String title, String name, String age, MessageSource messageSource) {
    SignupForm form = new SignupForm();
    DataBinder binder = new DataBinder(form, "signupForm");
    binder.setValidator(new SignupFormValidator());

    MutablePropertyValues values = new MutablePropertyValues();
    values.add("name", name);
    values.add("age", age);
    binder.bind(values);
    binder.validate();

    BindingResult result = binder.getBindingResult();
    log.info("{}", title);
    log.info("Binding result: name='{}', age={}", form.getName(), form.getAge());
    log.info("Total errors: {}", result.getErrorCount());
    for (FieldError error : result.getFieldErrors()) {
      log.info("Field={}, message={}, error codes={}",
          error.getField(), messageSource.getMessage(error, Locale.ENGLISH), Arrays.toString(error.getCodes()));
    }
  }
}
