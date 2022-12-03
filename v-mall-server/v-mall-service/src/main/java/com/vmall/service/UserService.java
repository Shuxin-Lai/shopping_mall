package com.vmall.service;

import com.vmall.common.exception.VMallException;
import com.vmall.vo.UserVO;

public interface UserService {
  UserVO findUserById(String id) throws VMallException;

  UserVO findUserByUsername(String username) throws VMallException;

  UserVO findUserByEmail(String email) throws VMallException;
}
