package com.vmall.common.utils;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdUtil;

public class CoreUtils {

  public static boolean isEmail(String value) {
    return Validator.isEmail(value);
  }

  public static Long generateId() {
    return IdUtil.getSnowflake().nextId();
  }

  public static void main(String[] args) {}
}
