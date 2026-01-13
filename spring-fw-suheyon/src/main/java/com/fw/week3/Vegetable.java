package com.fw.week3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Vegetable {
  private String name; // tomato
  private String type; // fruit tomato


  // Setter
  public void setName(String name) {this.name = name;}
  public void setType(String type) { this.type = type; }

  // Getter
  public String getName() { return this.name; }
  public String getType() {
    return this.type;
  }

  // Conrstructor
  public Vegetable() {
    log.info("\ncreate: Vegetable bean");
  }
}
