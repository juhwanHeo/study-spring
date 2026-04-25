package com.fw.week5;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service("gamjaService")
public class GamjaServiceImpl implements MyService{

  @Value("${gamja.count}")
  private int count;

  @Override
  public void hello() {
    log.info("GamjaServiceImpl 재배 감자는 {}개 입니다.", count);
  }
}
