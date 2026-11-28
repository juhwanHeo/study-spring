package com.fw.week11;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderForm {

    private ProductCode productCode;
    private LocalDate deliveryDate;
}
