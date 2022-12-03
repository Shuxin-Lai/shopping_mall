package com.vmall.common.exception;

public enum VMallExceptionEnum {
  SYS_ERROR(20000, "system error"),
  UPDATED_FAILED(190000, "failed to update"),
  INSERTED_FAILED(190001, "failed to insert"),
  PARA_ERROR(100000, "parameter error");

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
