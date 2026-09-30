package com.fw;

import com.fw.week10.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@Slf4j
public class Main {
  public static void main(String[] args) {
    ResourceService resourceService = new ResourceService();
    ResourceLoader resourceLoader = new DefaultResourceLoader();

    Resource classpathResource = resourceLoader.getResource("classpath:sample.txt");
    Resource filepathResource = resourceLoader.getResource("file:C:\\Users\\Seeds\\IdeaProjects\\study-spring\\spring-fw-siyoung\\src\\main\\java\\com\\fw\\week10\\sample.txt");
    Resource unknownResource = resourceLoader.getResource("우시영");

    resourceService.printResource(classpathResource);
    resourceService.printResource(filepathResource);
    resourceService.printResource(unknownResource);
  }
}