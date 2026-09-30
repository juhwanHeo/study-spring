package com.fw.week5;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

  @Autowired
  @Qualifier("myServiceImpl")
  private MyService myService;

//  private MyService gamjaService;

  @Resource
  @Qualifier("gamjaServiceImpl")
  private ObjectProvider<MyService> myServiceProvider;

  public void sayHello() {
    myService.hello();
    MyService ifAvailable = myServiceProvider.getIfAvailable();
    if (ifAvailable != null) {
      ifAvailable.hello();
    }
  }
}
