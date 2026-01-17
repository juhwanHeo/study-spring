package com.fw.week3;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Food {
  @Setter
  private String name;
  private String type;

  Food() {
    log.info("Food 생성!");
  }

  public void setType(String type) {
    try {
      this.type = Types.valueOf(type).getDescription();
    } catch (IllegalArgumentException e) {
      this.type = Types.ETC.getDescription();
    }
  }

  @Getter
  @AllArgsConstructor
  private enum Types {
    KR("한식"), CH("중식"), JP("일식"), EU("양식"), ETC("ETC");

    private final String description;
  }
}
