package com.fw.week5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("gamjaServiceImpl")
@Scope("prototype")
@Slf4j
public class GamjaServiceImpl implements MyService{

  @Value( "${gamja.count}")
  private int count;

  private static int cnt = 0;

  @Override
  public void hello() {
    log.info("GamjaServiceImpl count : {}", count);
  }

  public GamjaServiceImpl() {
    cnt++;
    log.info("GamjaServiceImpl 새 인스턴스 생성: 생성 횟수 = {}", cnt);
  }
}
