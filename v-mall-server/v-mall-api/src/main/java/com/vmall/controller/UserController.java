package com.vmall.controller;

import com.vmall.common.api.ApiRestResponse;
import com.vmall.common.exception.VMallException;
import com.vmall.service.UserService;
import com.vmall.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ApiRestResponse findUserById(@PathVariable("id") String id)
    throws VMallException {
    UserVO user = userService.findUserById(id);
    return ApiRestResponse.success(user);
  }
}
