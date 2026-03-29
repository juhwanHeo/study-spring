package com.fw.week5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class GamjaServiceImpl implements MyService {
  @Value("${gamja.count}")
  private String gamjaCount;

  @Override
  public void hello() {
    log.info("[gamja] hello from Chuncheon");
    log.info("[gamja count]: {} ", gamjaCount);
  }

}
