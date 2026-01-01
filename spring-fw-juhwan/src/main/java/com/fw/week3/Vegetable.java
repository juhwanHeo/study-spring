package com.fw.week3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class Vegetable {

  private String name;
  private Type type;

  public Vegetable() {
    log.info("Vegetable 생성!");
  }

  @Getter
  public enum Type {
    ROOT("뿌리채소"),
    LEAF("잎채소"),
    FRUIT("열매채소"),
    ;

    private final String value;

    Type(String value) {
      this.value = value;
    }
  }
}
