package com.vmall.common.api;

public class ApiRestResponse<T> {

  private static final int SUCCESS_CODE = 200;
  private static final String SUCCESS_MESSAGE = "success";

  private int code;
  private String message;
  private T data;

  public ApiRestResponse(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static ApiRestResponse success() {
    return success(null);
  }

  public static <T> ApiRestResponse success(T data) {
    return new ApiRestResponse(SUCCESS_CODE, SUCCESS_MESSAGE, data);
  }

  public static <T> ApiRestResponse error(int code, String message) {
    return error(code, message, null);
  }

  public static <T> ApiRestResponse error(int code, String message, T data) {
    return new ApiRestResponse(code, message, data);
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

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
