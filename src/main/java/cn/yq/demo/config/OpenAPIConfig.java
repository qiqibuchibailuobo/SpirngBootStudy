package cn.yq.demo.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public GroupedOpenApi restApi() {
    return GroupedOpenApi.builder()
            .group("rest-api")
            .pathsToMatch("/rest/**")
            .build();
  }

  @Bean
  public GroupedOpenApi helloApi() {
    return GroupedOpenApi.builder()
            .group("hello")
            .pathsToMatch("/hello/**")
            .build();
  }

  @Bean
  public GroupedOpenApi articlesApi() {
    return GroupedOpenApi.builder()
            .group("articles")
            .pathsToMatch("/articles/**")
            .build();
  }
}