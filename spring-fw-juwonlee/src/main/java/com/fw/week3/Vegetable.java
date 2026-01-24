package com.fw.week3;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
public class Vegetable {
    private String name;
    private VegetableType type;
}
