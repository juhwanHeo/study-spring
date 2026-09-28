package com.fw.week10;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Spring Resource 추상화를 이용해 다양한 위치의 파일을 읽는 서비스.
 *
 * location 문자열을 보고 ClassPathResource / FileSystemResource 를 직접 new 하지 않고,
 * 스프링이 제공하는 ResourceLoader 에 조회를 위임한다.
 * (ApplicationContext 는 ResourceLoader 를 구현하며, 컨테이너가 자기 자신을
 *  ResourceLoader 타입의 의존성으로 주입해준다.)
 *
 * ResourceLoader 는 location 의 prefix 로 구현체를 결정한다.
 *   - classpath:  -> ClassPathResource
 *   - file:, http: 등 URL 형식 -> FileUrlResource / UrlResource
 *   - prefix 없음 -> ApplicationContext 구현체의 기본 규칙 (AnnotationConfigApplicationContext 는 ClassPathContextResource)
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceLoader resourceLoader;

    /**
     * location 에 해당하는 Resource 를 스프링의 ResourceLoader 로 조회한다.
     *
     * @throws ResourceNotFoundException 조회한 Resource 가 실제로 존재하지 않는 경우
     */
    public Resource getResource(String location) {
        Resource resource = resourceLoader.getResource(location);

        if (!resource.exists()) {
            throw new ResourceNotFoundException(location, resource.getDescription());
        }
        return resource;
    }

    /**
     * location 으로 Resource 를 가져온 뒤 정보를 출력한다.
     */
    public void printResource(String location) {
        printResource(getResource(location));
    }

    /**
     * 전달받은 Resource 의 정보(파일명, 존재 여부, 읽기 가능 여부, 실제 내용)를 로그로 출력한다.
     */
    public void printResource(Resource resource) {
        log.info("    구현체      : {}", resource.getClass().getSimpleName());
        log.info("    설명        : {}", resource.getDescription());
        log.info("    파일명      : {}", resource.getFilename());
        log.info("    존재 여부   : {}", resource.exists());
        log.info("    읽기 가능   : {}", resource.isReadable());

        // 방어 코드: getResource() 를 거치지 않고 직접 전달된 Resource 도 안전하게 처리
        if (!resource.exists() || !resource.isReadable()) {
            log.warn("    내용        : (읽을 수 없는 Resource 입니다)");
            return;
        }

        try {
            // Spring 6.0+ : Resource#getContentAsString(Charset)
            String content = resource.getContentAsString(StandardCharsets.UTF_8);
            log.info("    내용        : {}", content.strip());
        } catch (IOException e) {
            log.error("    내용        : 읽기 실패 - {}", e.getMessage());
        }
    }

    /**
     * 요청한 location 에 해당하는 Resource 가 존재하지 않을 때 발생하는 예외.
     *
     * ResourceLoader#getResource(String) 는 대상이 없어도 예외를 던지지 않고
     * Resource 핸들만 반환하므로, exists() 가 false 인 경우 이 예외로 변환한다.
     * ResourceService 에서만 쓰이므로 별도 파일 대신 static 중첩 클래스로 둔다.
     */
    @Getter
    public static class ResourceNotFoundException extends RuntimeException {

        private final String location;

        public ResourceNotFoundException(String location, String description) {
            super("Resource 를 찾을 수 없습니다. location=" + location + ", description=" + description);
            this.location = location;
        }
    }
}
