package com.fw;

import com.fw.week5.GamjaServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.fw.week5.MyServiceImpl;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World");

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("week5.xml");
        MyServiceImpl myService = context.getBean("myServiceImpl", MyServiceImpl.class);
        GamjaServiceImpl gamjaService = context.getBean("gamjaServiceImpl", GamjaServiceImpl.class);

        myService.hello();
        gamjaService.hello();

        context.close();
    }
}
