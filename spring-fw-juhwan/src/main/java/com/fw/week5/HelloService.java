package com.fw.week5;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

  @Autowired
  private MyServiceImpl myService;

  @Resource
  private GamjaServiceImpl gamjaService;

  public void sayHello() {
    myService.hello();
    gamjaService.hello();
  }
}
