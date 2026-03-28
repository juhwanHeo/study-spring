package com.fw.week5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class GamjaServiceImpl implements MyService{

  @Value( "${gamja.count}")
  private int count;

  @Value( "${gamja.location}")
  private String location;

  @Override
  public void hello() {
    log.info("GamjaServiceImpl location : {}", location);
    log.info("GamjaServiceImpl count : {}", count);
  }
}
