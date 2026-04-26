package com.fw.week5;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service("gamjaServiceImpl")
@Scope("prototype")
public class GamjaServiceImpl implements MyService {

    @Value("${gamja.count}")
    private int count;

    @PostConstruct
    public void init() {
        log.info("GamjaServiceImpl init");
    }

    @Override
    public void hello() {
        log.info("GamjaServiceImpl Hello");
        log.info("GamjaServiceImpl gamja count: {}", count);
    }
}
