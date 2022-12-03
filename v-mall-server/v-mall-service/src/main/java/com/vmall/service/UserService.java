package com.vmall.service;

import com.vmall.common.exception.VMallException;
import com.vmall.vo.UserVO;

public interface UserService {
  UserVO findUserById(String id) throws VMallException;

  UserVO findUserByUsername(String username, String password)
    throws VMallException;

  UserVO findUserByEmail(String email, String password) throws VMallException;

  UserVO register(String email, String password) throws VMallException;

  UserVO login(String email, String password) throws VMallException;
}
