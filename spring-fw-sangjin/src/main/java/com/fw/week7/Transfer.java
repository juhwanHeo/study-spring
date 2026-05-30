package com.fw.week7;

public class Transfer {

    private final Gamja gamja;

    public Transfer(Gamja gamja) {
        this.gamja = gamja;
    }

    public void transfer() {
        System.out.println("[Transfer] 감자 " + gamja.getCount() + "개를 이동합니다.");
    }
}
