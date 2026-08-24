package com.fw.week7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Transfer {
  Gamja gamja;

  public Transfer(Gamja param) {
    gamja = param;
  }

  public void transfer() {
    log.info("감자 {}개를 이동", gamja.getCount());
  }
}
