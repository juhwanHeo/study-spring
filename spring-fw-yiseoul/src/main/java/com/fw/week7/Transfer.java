package com.fw.week7;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Transfer {
  private final Gamja gamja;

  public void transfer() {
    log.info("감자가 {}개 이동합니다.", gamja.getCount());
  }
}
