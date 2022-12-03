package com.vmall.service;

import com.vmall.common.exception.VMallException;
import com.vmall.vo.CurrentUser;
import com.vmall.vo.UserVO;

public interface JwtService {
  Object signForUser(UserVO userVO);

  CurrentUser parseForUser(String accessToken) throws VMallException;
}
