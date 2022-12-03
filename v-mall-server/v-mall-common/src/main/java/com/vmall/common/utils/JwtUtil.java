package com.vmall.common.utils;

import cn.hutool.core.exceptions.ValidateException;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.vmall.common.Constant;
import com.vmall.common.exception.VMallException;
import com.vmall.common.exception.VMallExceptionEnum;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

  public static String sign(Map<String, Object> payload) {
    //    String token = JWTUtil.createToken(payload, Constant.JWT_SECRET.getBytes());
    return JWT
      .create()
      .addPayloads(payload)
      .setSigner(JWTSignerUtil.hs256(Constant.JWT_SECRET.getBytes()))
      .setExpiresAt(
        new Date(System.currentTimeMillis() + Constant.JWT_EXPIRATION_TIME)
      )
      .sign();
  }

  public static JSONObject parse(String token) throws VMallException {
    String normalizedToken = StrUtil
      .replaceFirst(token, Constant.JWT_HEADER, "")
      .trim();

    try {
      boolean verify = JWTUtil.verify(
        normalizedToken,
        Constant.JWT_SECRET.getBytes()
      );
      if (!verify) {
        throw new VMallException(VMallExceptionEnum.INVALID_TOKEN);
      }
    } catch (Exception e) {
      throw new VMallException(VMallExceptionEnum.INVALID_TOKEN);
    }

    JWT jwt = JWTUtil.parseToken(normalizedToken);
    try {
      JWTValidator.of(jwt).validateDate();
    } catch (ValidateException e) {
      throw new VMallException(VMallExceptionEnum.TOKEN_HAS_EXPIRED);
    }
    return jwt.getPayloads();
  }

  public static void main(String[] args) {
    HashMap<String, Object> stringObjectHashMap = new HashMap<>();
    stringObjectHashMap.put("username", 1);

    String sign = sign(stringObjectHashMap);
    System.out.println(sign);
  }
}
