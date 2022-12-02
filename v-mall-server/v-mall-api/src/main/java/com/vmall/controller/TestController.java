package com.vmall.controller;

import com.vmall.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  @Autowired
  TestService testService;

  @RequestMapping("/ping")
  public Object ping() {
    return "pong";
  }

  @RequestMapping("/object")
  public Object findObject() {
    return testService.findTest();
  }

  @RequestMapping("/mapper")
  public Object findMapper() {
    return testService.findMapper();
  }
}
