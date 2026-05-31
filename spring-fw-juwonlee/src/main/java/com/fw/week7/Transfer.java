package com.fw.week7;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Transfer {
    private final Gamja gamja;

    public Transfer(Gamja gamja) {
        this.gamja = gamja;
    }

    public void transfer() {
        log.info("Transfer gamja start");
        int transferCount = gamja.transferCount();
        log.info("Transfer gamja end");
        log.info("Transfer gamja count: {}", transferCount);
    }
}
