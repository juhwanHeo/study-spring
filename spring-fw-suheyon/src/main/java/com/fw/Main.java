package com.fw;

import com.fw.week11.AppConfig;
import com.fw.week11.SignupForm;
import com.fw.week11.SignupFormValidator;
import java.util.Arrays;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;

@Slf4j
public class Main {

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    MessageSource messageSource = ctx.getBean(MessageSource.class);

    // 입력값
    signup("정상 입력", "홍길동", "20", messageSource);
    signup("검증 실패", " ", "13", messageSource);
    signup("타입 변환 실패", "홍길동", "abc", messageSource);

    ctx.close();
  }

  private static void signup(String title, String name, String age, MessageSource messageSource) {
    log.info("[{}] Input Name: {}, Age: {}", title, name, age);

    MutablePropertyValues values = new MutablePropertyValues();
    values.add("name", name);
    values.add("age", age);

    SignupForm form = new SignupForm();
    DataBinder binder = new DataBinder(form, "signupForm");
    binder.setValidator(new SignupFormValidator());

    binder.bind(values);
    binder.validate();

    BindingResult result = binder.getBindingResult();

    // 바인딩된 객체의 이름과 나이
    log.info("[Binding] Name: {}, Age: {}", form.getName(), form.getAge());
    // 전체 오류 개수
    log.info("[Errors] Count: {}", result.getErrorCount());

    for (FieldError error : result.getFieldErrors()) {
      // 각 필드 오류의 필드명, 오류 코드 목록, 최종 메시지
      log.info("[FieldError] Field: {}, Codes: {}, Message: {}",
          error.getField(), Arrays.toString(error.getCodes()),
          messageSource.getMessage(error, Locale.getDefault()));
    }
  }
}
