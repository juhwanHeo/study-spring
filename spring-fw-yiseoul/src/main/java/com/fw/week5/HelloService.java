package com.fw.week5;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @Autowired
  @Qualifier("myService")
  private MyService myServiceImpl;

  @Resource
  @Qualifier("gamjaService")
  private ObjectProvider<MyService> gamjaServiceImpl;

  public void sayHello() {
    myServiceImpl.hello();
    MyService gamjaServiceImpl = this.gamjaServiceImpl.getObject();
    gamjaServiceImpl.hello();
  }
}
