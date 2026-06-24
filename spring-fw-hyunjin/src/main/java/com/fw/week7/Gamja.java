package com.fw.week7;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Gamja implements TransferObject {

    private final int count;

    public Gamja(int count) {
        this.count = count;
    }

    @Override
    public int transferCount() {
        return count;
    }
}