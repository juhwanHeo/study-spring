package com.fw.week3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Vegetable {
  @Setter
  private String name;
  private String type;

  Vegetable() {
    log.info("Vegetable 생성!");
  }

  public void print() {
    log.info("좋아하는 채소는 {} {}입니다.", type, name);
  }

  public void setType(String type) {
    this.type = Types.valueOf(type).getDescription();
  }

  @Getter
  @AllArgsConstructor
  private enum Types {
    RT("뿌리채소"), LF("잎채소"), FR("열매채소");

    private final String description;
  }
}
