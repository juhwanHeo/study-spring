package com.fw.week5;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServiceImpl implements MyService {

  @Override
  public void hello() {
    log.info("[MyServiceImpl] hello");
  }
}
