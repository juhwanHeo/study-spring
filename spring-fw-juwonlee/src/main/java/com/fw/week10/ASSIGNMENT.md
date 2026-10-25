# 10주차 과제: Spring Resource

## 목표

Spring의 Resource 조회 기능으로 클래스패스와 파일 시스템의 텍스트 파일을 읽고, 조회 결과와 내용을 로그로 출력한다.

## 요구사항

- `ApplicationContext.getResource(location)`을 사용해 `classpath:` 및 절대 파일 URI의 Resource를 조회한다.
- `ResourceService.printResource(Resource)`에서 파일명, 존재 여부, 읽기 가능 여부, 실제 내용을 로그로 출력한다.
- 존재하지 않는 Resource는 예외로 처리하고 로그에 남긴다.
- 실행 진입점에서 두 정상 경로와 존재하지 않는 경로를 모두 확인한다.
