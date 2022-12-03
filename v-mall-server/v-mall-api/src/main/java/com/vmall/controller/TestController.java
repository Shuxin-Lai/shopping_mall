package com.vmall.controller;

import com.vmall.annotation.User;
import com.vmall.common.api.ApiRestResponse;
import com.vmall.common.exception.VMallException;
import com.vmall.common.utils.JwtUtil;
import com.vmall.service.TestService;
import com.vmall.vo.CurrentUser;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @RequestMapping(value = "/jwt_token", method = { RequestMethod.GET })
  public ApiRestResponse testJwtToken() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("username", "123");
    return ApiRestResponse.success(JwtUtil.sign(map));
  }

  @RequestMapping(value = "/jwt_token_parse", method = { RequestMethod.GET })
  public ApiRestResponse testJwtTokenParse(@RequestParam String jwtToken)
    throws VMallException {
    return ApiRestResponse.success(JwtUtil.parse(jwtToken));
  }

  @RequestMapping("/throwable")
  public ApiRestResponse throwable() throws VMallException {
    testService.shouldThrow();
    return ApiRestResponse.success();
  }

  @RequestMapping(value = "/annotation", method = { RequestMethod.GET })
  public ApiRestResponse annotation(@User CurrentUser user) {
    return ApiRestResponse.success(user);
  }
}
