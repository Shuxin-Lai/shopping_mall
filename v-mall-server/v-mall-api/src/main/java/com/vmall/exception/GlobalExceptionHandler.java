package com.vmall.exception;

import com.vmall.common.api.ApiRestResponse;
import com.vmall.common.exception.VMallException;
import com.vmall.common.exception.VMallExceptionEnum;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LogManager.getLogger(
    GlobalExceptionHandler.class
  );

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Object handleException(Exception e) {
    logger.error("Default Exception: ", e);
    return ApiRestResponse.error(
      VMallExceptionEnum.SYS_ERROR.getCode(),
      e.getMessage()
    );
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseBody
  public Object handleMessageNotReadableException(
    HttpMessageNotReadableException e
  ) {
    logger.error("Default Exception: ", e);
    return ApiRestResponse.error(VMallExceptionEnum.PARA_ERROR);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  @ResponseBody
  public Object handleMissingServletRequestParameterException(
    MethodArgumentNotValidException e
  ) {
    logger.error("MissingServletRequestParameterException Exception: ", e);
    String message = e.getMessage();
    return ApiRestResponse.error(
      VMallExceptionEnum.PARA_ERROR.getCode(),
      message
    );
  }

  @ExceptionHandler(VMallException.class)
  @ResponseBody
  public Object handleVMallException(VMallException e) {
    logger.error("VMall Exception: ", e);
    return ApiRestResponse.error(e.getCode(), e.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseBody
  public Object handleMethodArgumentNotValidException(
    MethodArgumentNotValidException e
  ) {
    logger.error("MethodArgumentNotValidException: ", e);
    return handleBindingResult(e.getBindingResult());
  }

  private ApiRestResponse handleBindingResult(BindingResult result) {
    List<String> list = null;
    if (result.hasErrors()) {
      list = new ArrayList<>();
      for (FieldError fieldError : result.getFieldErrors()) {
        list.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
      }
    }

    if (list == null) {
      return ApiRestResponse.error(VMallExceptionEnum.PARA_ERROR);
    }
    return ApiRestResponse.error(
      VMallExceptionEnum.PARA_ERROR.getCode(),
      list.toString()
    );
  }
}
