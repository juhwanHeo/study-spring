package com.fw.week3;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
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

  @PostConstruct
  public void initialize() {
    log.info("Food 탄생!");
  }

  @PreDestroy
  public void destroy() {
    log.info("Food 파괴!");
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
