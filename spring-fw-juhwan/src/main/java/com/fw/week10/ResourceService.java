package com.fw.week10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResourceService {

  public void printResource(Resource resource) {
    boolean exists = resource.exists();
    boolean readable = resource.isReadable();

    log.info("리소스: {}", resource.getDescription());
    log.info("파일명: {}", resource.getFilename());
    log.info("존재 여부: {}", exists);
    log.info("읽기 가능 여부: {}", readable);

    try {
      if (!exists) {
        throw new FileNotFoundException("리소스가 존재하지 않습니다.");
      }
      if (!readable) {
        throw new IOException("리소스를 읽을 수 없습니다.");
      }

      String content = resource.getContentAsString(StandardCharsets.UTF_8);
      log.info("실제 내용: {}", content);
    } catch (IOException e) {
      log.error("리소스 읽기 실패: {}", resource.getDescription(), e);
    }
  }
}
