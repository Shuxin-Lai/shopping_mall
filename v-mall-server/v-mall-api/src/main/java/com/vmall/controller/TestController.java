package com.vmall.controller;

import com.vmall.common.api.ApiRestResponse;
import com.vmall.common.exception.VMallException;
import com.vmall.service.TestService;
import java.util.HashMap;
import java.util.Map;
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

  @RequestMapping("/restful")
  public ApiRestResponse testRest() {
    Map<String, String> data = new HashMap<>();
    data.put("username", "username");

    return ApiRestResponse.success(data);
  }

  @RequestMapping("/throwable")
  public ApiRestResponse throwable() throws VMallException {
    testService.shouldThrow();
    return ApiRestResponse.success();
  }
}
