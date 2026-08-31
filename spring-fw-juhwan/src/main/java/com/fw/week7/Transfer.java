package com.fw.week7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Transfer {

  private final Gamja gamja;

  public Transfer(Gamja gamja) {
    this.gamja = gamja;
  }

  public void transfer() {
    log.info("이동 시작");
    int transferCount = gamja.transferCount();
    log.info("이동 종료");
    log.info("이동된 수: {}", transferCount);
  }
}
