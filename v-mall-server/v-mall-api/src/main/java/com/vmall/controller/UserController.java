package com.vmall.controller;

import com.vmall.common.api.ApiRestResponse;
import com.vmall.common.exception.VMallException;
import com.vmall.dto.user.RegisterDto;
import com.vmall.service.JwtService;
import com.vmall.service.UserService;
import com.vmall.vo.UserVO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private JwtService jwtService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ApiRestResponse findUserById(@PathVariable("id") String id)
    throws VMallException {
    UserVO user = userService.findUserById(id);
    return ApiRestResponse.success(user);
  }
}
