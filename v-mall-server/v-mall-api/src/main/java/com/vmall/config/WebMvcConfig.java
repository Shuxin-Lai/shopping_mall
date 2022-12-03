package com.vmall.config;

import com.vmall.annotation.CurrentUserMethodArgumentResolver;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  @Bean
  public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
    return new CurrentUserMethodArgumentResolver();
  }

  @Override
  public void addArgumentResolvers(
    List<HandlerMethodArgumentResolver> argumentResolvers
  ) {
    argumentResolvers.add(currentUserMethodArgumentResolver());
  }
}
