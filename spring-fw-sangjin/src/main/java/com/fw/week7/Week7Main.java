package com.fw.week7;

import jakarta.inject.Provider;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Week7Main {

    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("  Week7: Provider / ObjectProvider & AppConfig");
        System.out.println("==================================================\n");

        try (AnnotationConfigApplicationContext ctx =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            // ObjectProvider 를 한 번 얻어, Provider 와 ObjectProvider 둘 다로 사용
            ObjectProvider<MyService> objectProvider = ctx.getBeanProvider(MyService.class);

            System.out.println("jakarta.inject.Provider<T>.get() 사용");

            Provider<MyService> provider = objectProvider::getObject;
            for (int i = 1; i <= 3; i++) {
                System.out.printf("  [Provider.get() %d회차]%n", i);
                MyService gamja = provider.get();
                gamja.hello();
                System.out.println();
            }

            // Spring ObjectProvider<T>.getObject() 사용
            System.out.println("--------------------------------------------------");
            System.out.println("ObjectProvider<T>.getObject() 사용");
            System.out.println("--------------------------------------------------");

            for (int i = 1; i <= 3; i++) {
                System.out.printf("  [ObjectProvider.getObject() %d회차]%n", i);
                MyService gamja = objectProvider.getObject();
                gamja.hello();
                System.out.println();
            }

            // AppConfig 의 Transfer 빈 가져와서 transfer() 호출
            System.out.println("--------------------------------------------------");
            System.out.println("AppConfig 의 Transfer 빈 호출");
            System.out.println("--------------------------------------------------");

            Transfer transfer = ctx.getBean(Transfer.class);
            transfer.transfer();
            System.out.println();
        }
    }
}
