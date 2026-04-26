package com.fw.week5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("myServiceImpl")
public class MyServiceImpl implements MyService {

    @Override
    public void hello() {
        log.info("MyServiceImpl Hello");
    }
}
