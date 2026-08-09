package com.fw.week5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Scope("prototype")
public class GamjaServiceImpl implements MyService {
  @Value("${gamja.count}")
  private String gamjaCount;

  public GamjaServiceImpl() {
    log.info("GamjaServiceImpl instance created!: this={}", this);
  }

  @Override
  public void hello() {
    log.info("[gamja] hello from Chuncheon");
    log.info("[gamja count]: {} ", gamjaCount);
  }

}
