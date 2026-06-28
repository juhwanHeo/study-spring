package com.fw;

import com.fw.week7.AppConfig;
import com.fw.week7.Transfer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("----- Transfer 호출 -----");

        Transfer transfer = context.getBean(Transfer.class);
        transfer.transfer();

        context.close();
    }
}

