package com.vmall.service.impl;

import cn.hutool.json.JSONObject;
import com.vmall.common.exception.VMallException;
import com.vmall.common.utils.JwtUtil;
import com.vmall.service.JwtService;
import com.vmall.vo.CurrentUser;
import com.vmall.vo.UserVO;
import java.util.HashMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

  @Override
  public Object signForUser(UserVO userVO) {
    CurrentUser currentUser = new CurrentUser();
    BeanUtils.copyProperties(userVO, currentUser);

    HashMap<String, Object> payload = new HashMap<>();
    payload.put("id", currentUser.getId());
    payload.put("email", currentUser.getEmail());

    String accessToken = JwtUtil.sign(payload);
    HashMap<String, Object> data = new HashMap<>();

    data.put("accessToken", accessToken);
    return data;
  }

  @Override
  public CurrentUser parseForUser(String accessToken) throws VMallException {
    JSONObject currentUserPayload = JwtUtil.parse(accessToken);
    return createCurrentUser(currentUserPayload);
  }

  private CurrentUser createCurrentUser(JSONObject currentUserPayload) {
    CurrentUser currentUser = new CurrentUser();
    currentUser.setEmail((String) currentUserPayload.get("email"));
    currentUser.setId((Long) currentUserPayload.get("id"));
    return currentUser;
  }
}
