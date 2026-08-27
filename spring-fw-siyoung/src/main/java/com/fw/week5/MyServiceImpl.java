package com.fw.week5;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service("myServiceImpl")
@RequiredArgsConstructor
public class MyServiceImpl implements MyService{

  private final ObjectProvider<GamjaServiceImpl> gamjaProvider;

  @Override
  public void hello() {
    gamjaProvider.getObject().hello();
  }
}
