package com.vmall.common.exception;

public enum VMallExceptionEnum {
  SYS_ERROR(20000, "system error"),
  INVALID_TOKEN(18000, "invalid token"),
  TOKEN_HAS_EXPIRED(18001, "token has expired"),
  UPDATED_FAILED(19000, "failed to update"),
  INSERTED_FAILED(19001, "failed to insert"),
  PARA_ERROR(10000, "parameter error"),
  USER_EXIST(10001, "user exist"),
  USER_NOT_FOUND(10002, "user not found"),
  EMAIL_NOT_EXIST(10003, "email not exits"),
  WRONG_PASSWORD(10004, "password is incorrect"),
  UNAUTHORIZED(10005, "unauthorized");

  private int code;
  private String message;

  VMallExceptionEnum(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
