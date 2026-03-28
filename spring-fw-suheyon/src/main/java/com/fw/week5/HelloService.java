package com.fw.week5;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class HelloService {

  @Autowired
  private MyServiceImpl myServiceImpl;

  @Resource
  private GamjaServiceImpl gamjaServiceImpl;

  public void sayHello() {
    log.info("[HelloService] sayHello");
    myServiceImpl.hello();
    gamjaServiceImpl.hello();
  }
}
