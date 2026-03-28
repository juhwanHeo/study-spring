package com.fw.week3;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@AllArgsConstructor
public class Food {

  private String name;
  private Type type;

  public Food() {
    log.info("Food 생성!");
  }

  @PostConstruct
  public void init() {
    log.info("Food @PostConstruct 실행!");
  }

  @PreDestroy
  public void destroy() {
    log.info("Food @PreDestroy 실행!");
  }

  @Getter
  public enum Type {
    KOR("한식"),
    CHN("중식"),
    JPN("일식"),
    WESTERN("양식"),
    ETC("기타"),
    ;

    private final String value;

    Type(String value) {
      this.value = value;
    }
  }
}
