package com.vmall.common.exception;

public class VMallException extends Exception {

  private int code;
  private String message;

  public VMallException(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public VMallException(VMallExceptionEnum exceptionEnum) {
    this(exceptionEnum.getCode(), exceptionEnum.getMessage());
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return (
      "VMallException{" + "code=" + code + ", message='" + message + '\'' + '}'
    );
  }
}
