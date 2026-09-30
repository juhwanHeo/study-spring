package com.fw.week10;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceService {

  private final ResourceLoader resourceLoader;

  public Resource getResource(String location) {
    return resourceLoader.getResource(location);
  }

  public void printResource (Resource resource) {
    if (resource == null) {
      log.warn("Resource가 null입니다.");
      return;
    }

    boolean rExists = resource.exists();
    boolean rReadable = resource.isReadable();

    log.info("파일명: {}", resource.getFilename());
    log.info("Resource Is Exists: {}", rExists);
    log.info("Resource Is Readable: {}", rReadable);

    if (!rExists || !rReadable) {
      log.info("Resource 읽을 수 없는 contents: {}", resource.getDescription());
      return;
    }

    try (InputStream is = resource.getInputStream()) {
      String content = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
      log.info("Resource Contents: {}", content);
    } catch (Exception e) {
      log.error("Error reading resource: {}", e.getMessage());
    }
  }
}
