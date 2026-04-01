package com.fw.week5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class GamjaServiceImpl implements MyService {

  @Value("${gamja.count}")
  private int count;

  @Override
  public void hello() {
    log.info(">>> GamjaServiceImpl hello");
    log.info(">>> GamjaServiceImpl gamja count: {}", count);
  }
}
