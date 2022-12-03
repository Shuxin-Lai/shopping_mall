package com.vmall.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constant {

  public static String SALT = null;
  public static String JWT_SECRET = null;
  public static String JWT_HEADER = null;
  public static Integer JWT_EXPIRATION_TIME = null;

  @Value("${constant.salt}")
  public void setSALT(String SALT) {
    Constant.SALT = SALT;
  }

  @Value("${constant.jwt_secret}")
  public void setJwtSecret(String jwtSecret) {
    JWT_SECRET = jwtSecret;
  }

  @Value("${constant.jwt_header}")
  public void setJwtHeader(String jwtHeader) {
    JWT_HEADER = jwtHeader;
  }

  @Value("${constant.jwt_expiration_time}")
  public void setJwtExpirationTime(Integer jwtExpirationTime) {
    JWT_EXPIRATION_TIME = jwtExpirationTime;
  }
}
