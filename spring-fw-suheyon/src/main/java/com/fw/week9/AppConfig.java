package com.fw.week9;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({OrderPublisher.class, OrderConsumer.class})
public class AppConfig {

}