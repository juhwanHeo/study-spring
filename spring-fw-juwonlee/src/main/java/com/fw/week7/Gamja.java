package com.fw.week7;

import lombok.Data;

@Data
public class Gamja {
    private int count;

    public Gamja(int count) {
        this.count = count;
    }

    public int transferCount() {
        return count;
    }
}
