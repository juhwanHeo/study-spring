package com.fw.week11;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            Validator validator =
                    context.getBean(SignupFormValidator.class);

            MessageSource messageSource =
                    context.getBean(MessageSource.class);

            // 1. 정상 입력
            print("정상 입력",
                    bind(validator, "홍길동", "20"), messageSource);

            // 2. 검증 실패
            print("검증 실패",
                    bind(validator, " ", "13"), messageSource);

            // 3. 타입 변환 실패
            print("타입 변환 실패",
                    bind(validator, "홍길동", "abc"), messageSource);

            ConversionService conversionService =
                    context.getBean(ConversionService.class);

            // 4. 주문: 정상 입력
            printOrder("주문 정상 입력",
                    bindOrder(conversionService, " book-001 ", "2026/10/25"),
                    conversionService);

            // 5. 주문: 상품 코드 오류
            printOrder("상품 코드 오류",
                    bindOrder(conversionService, " ", "2026/10/25"),
                    conversionService);

            // 6. 주문: 날짜 오류
            printOrder("날짜 오류",
                    bindOrder(conversionService, "book-001", "2026/02/30"),
                    conversionService);
        }
    }

    static BindingResult bindOrder(
            ConversionService conversionService,
            String productCode,
            String deliveryDate
    ) {
        DataBinder binder = new DataBinder(new OrderForm(), "orderForm");
        binder.setConversionService(conversionService);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("productCode", productCode);
        propertyValues.add("deliveryDate", deliveryDate);

        // 타입 변환은 바인딩 과정에서 ConversionService가 수행
        binder.bind(propertyValues);

        return binder.getBindingResult();
    }

    private static void printOrder(
            String title,
            BindingResult bindingResult,
            ConversionService conversionService
    ) {
        System.out.println("========== " + title + " ==========");

        if (bindingResult.hasErrors()) {
            for (FieldError error : bindingResult.getFieldErrors()) {
                System.out.println("- 필드명: " + error.getField());
                System.out.println("  오류 코드: " + error.getCode());
            }
        } else {
            OrderForm form = (OrderForm) bindingResult.getTarget();

            System.out.println("상품 코드: " + form.getProductCode().getValue());
            System.out.println("배송일: " + form.getDeliveryDate());
            System.out.println("배송일(문자열 변환): "
                    + conversionService.convert(form.getDeliveryDate(), String.class));
        }

        System.out.println();
    }

    static BindingResult bind(Validator validator, String name, String age) {

        // DataBinder는 대상 객체와 오류 상태를 가지므로 입력마다 새로 생성
        DataBinder binder = new DataBinder(new SignupForm(), "signupForm");
        binder.addValidators(validator);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name", name);
        propertyValues.add("age", age);

        // 바인딩 후 검증
        binder.bind(propertyValues);
        binder.validate();

        return binder.getBindingResult();
    }

    private static void print(
            String title,
            BindingResult bindingResult,
            MessageSource messageSource
    ) {
        SignupForm form = (SignupForm) bindingResult.getTarget();

        System.out.println("========== " + title + " ==========");
        System.out.println("이름: [" + form.getName() + "]");
        System.out.println("나이: " + form.getAge());
        System.out.println("전체 오류 개수: " + bindingResult.getErrorCount());

        for (FieldError error : bindingResult.getFieldErrors()) {
            System.out.println("- 필드명: " + error.getField());
            System.out.println("  오류 코드: " + Arrays.toString(error.getCodes()));
            System.out.println("  메시지: "
                    + messageSource.getMessage(error, Locale.KOREA));
        }

        System.out.println();
    }
}
