package com.fw;

import com.fw.week7.Transfer;
import com.fw.week7.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Transfer transfer = context.getBean(Transfer.class);
        transfer.transfer();

    }
}