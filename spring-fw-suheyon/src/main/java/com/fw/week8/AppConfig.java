package com.fw.week8;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(TransferRegistrar.class)
public class AppConfig {
}