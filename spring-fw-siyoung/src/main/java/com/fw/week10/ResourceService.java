package com.fw.week10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

@Slf4j
public class ResourceService {
  public void printResource(Resource resource) {
    log.info("파일명: {}", resource.getFilename());
    log.info("Resource 존재 여부 : {}", resource.exists());
    log.info("Resource 읽기 가능 여부 : {}", resource.isReadable());

    if (resource.exists()) {
      if (resource.isReadable()) {
        try {
          log.info("Resource 내용: {}", resource.getContentAsString(StandardCharsets.UTF_8));
        } catch (IOException e) {
          log.info("Resource 읽기를 실패했습니다.");
          throw new RuntimeException(e);
        }
      } else {
        log.info("Resource를 읽을 수 없습니다.");
      }
    } else {
      log.info("Resource가 존재하지 않습니다.");
    }

  }

}
