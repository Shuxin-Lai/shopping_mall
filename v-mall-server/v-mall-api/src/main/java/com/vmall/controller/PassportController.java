package com.vmall.controller;

import com.vmall.common.api.ApiRestResponse;
import com.vmall.common.exception.VMallException;
import com.vmall.dto.user.LoginDto;
import com.vmall.dto.user.RegisterDto;
import com.vmall.service.JwtService;
import com.vmall.service.UserService;
import com.vmall.vo.UserVO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/passport")
@RestController
public class PassportController {

  @Autowired
  private UserService userService;

  @Autowired
  private JwtService jwtService;

  @RequestMapping(value = "/login", method = { RequestMethod.POST })
  public ApiRestResponse login(@Valid @RequestBody LoginDto loginDto)
    throws VMallException {
    UserVO user = userService.login(
      loginDto.getEmail(),
      loginDto.getPassword()
    );
    Object result = jwtService.signForUser(user);
    return ApiRestResponse.success(result);
  }

  @RequestMapping(value = "/register", method = { RequestMethod.POST })
  public ApiRestResponse register(@Valid @RequestBody RegisterDto registerDto)
    throws VMallException {
    UserVO user = userService.register(
      registerDto.getEmail(),
      registerDto.getPassword()
    );
    Object result = jwtService.signForUser(user);

    return ApiRestResponse.success(result);
  }
}
