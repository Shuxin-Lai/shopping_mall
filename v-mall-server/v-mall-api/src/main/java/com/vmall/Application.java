package com.vmall;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages = "com.vmall.*")
@ComponentScan(basePackages = "com.vmall.*")
@MapperScan(basePackages = "com.vmall.mapper")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
