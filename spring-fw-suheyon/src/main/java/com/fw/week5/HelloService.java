package com.fw.week5;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Slf4j
public class HelloService {

  @Autowired
  @Qualifier("myServiceImpl")
  private MyService myServiceImpl;

  @Resource
  @Qualifier("gamjaServiceImpl")
  private MyService gamjaServiceImpl;

  public void sayHello() {
    log.info("[HelloService] sayHello");
    myServiceImpl.hello();
    gamjaServiceImpl.hello();
  }
}
