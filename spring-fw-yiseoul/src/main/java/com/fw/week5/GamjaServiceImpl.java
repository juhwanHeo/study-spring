package com.fw.week5;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Scope("prototype")
@Service("gamjaService")
public class GamjaServiceImpl implements MyService{

  @Value("${gamja.count}")
  private int count;

  @PostConstruct
  public void init() {
    log.info("GamjaServiceImpl 초기화 - hashCode: {}", this.hashCode());
  }

  @Override
  public void hello() {
    log.info("GamjaServiceImpl 재배 감자는 {}개 입니다.", count);
  }
}
