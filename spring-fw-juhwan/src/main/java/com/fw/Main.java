package com.fw;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {

    log.info("spring framework !!");
    for (int i = 1; i <= 5; i++) {
      log.info("i: {}", i);
    }
  }
}