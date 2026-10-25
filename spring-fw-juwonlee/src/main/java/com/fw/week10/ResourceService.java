package com.fw.week10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResourceService {

    public void printResource(Resource resource) {
        String fileName = resource.getFilename();
        boolean exists = resource.exists();
        boolean readable = resource.isReadable();

        log.info("Resource file name: {}", fileName);
        log.info("Resource exists: {}", exists);
        log.info("Resource is readable: {}", readable);

        try {
            if (!exists) {
                throw new FileNotFoundException(resource.getDescription());
            }
            if (!readable) {
                throw new IOException("Resource is not readable: " + resource.getDescription());
            }

            try (var inputStream = resource.getInputStream()) {
                String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                log.info("Resource content:\n{}", content);
            }
        } catch (IOException exception) {
            log.error("Failed to read resource {}", resource.getDescription(), exception);
        }
    }
}
