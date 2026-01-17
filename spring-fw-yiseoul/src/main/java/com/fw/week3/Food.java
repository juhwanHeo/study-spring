package com.fw.week3;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class Food {
  @Setter
  private String name;
  private String type;

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
