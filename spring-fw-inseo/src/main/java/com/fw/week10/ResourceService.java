package com.fw.week10;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class ResourceService {

    public void printResource(Resource resource) {

        // 1. Resource 기본 정보 출력
        log.info("========== Resource 정보 ==========");
        log.info("파일명: {}", resource.getFilename());
        log.info("존재 여부: {}", resource.exists());
        log.info("읽기 가능 여부: {}", resource.isReadable());

        try {
            // 2. 존재하지 않는 파일 예외 처리
            if (!resource.exists()) {
                throw new FileNotFoundException(
                        "파일을 찾을 수 없습니다: " + resource.getDescription()
                );
            }

            // 3. 읽을 수 없는 파일 예외 처리
            if (!resource.isReadable()) {
                throw new IOException(
                        "파일을 읽을 수 없습니다: " + resource.getDescription()
                );
            }

            // 4. Resource 파일 내용 읽기
            try (var inputStream = resource.getInputStream()) {

                String content = new String(
                        inputStream.readAllBytes(),
                        StandardCharsets.UTF_8
                );

                log.info("파일 내용: {}", content);
            }

        } catch (IOException e) {
            log.error("Resource 읽기 실패: {}", e.getMessage());
        }
    }
}
