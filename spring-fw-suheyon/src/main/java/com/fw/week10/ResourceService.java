package com.fw.week10;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.springframework.core.io.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ResourceService {
  public void printResource(Resource resource) {
    log.info("File name: {}", resource.getFilename()); // file name
    log.info("Is Resource Exist?: {}", resource.exists()); // boolean
    log.info("Can Resource be Read?: {}", resource.isReadable()); // boolean

    // contents
    try (InputStream inputStream = resource.getInputStream()) {
      String contents = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
      log.info("Resource Contents: {}", contents);
    } catch (IOException e) {
      log.error("Failed to read resource: {}", e.getMessage());
    }
  }

}
