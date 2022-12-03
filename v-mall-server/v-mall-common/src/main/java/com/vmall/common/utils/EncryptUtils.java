package com.vmall.common.utils;

import cn.hutool.crypto.SecureUtil;
import com.vmall.common.Constant;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.StringUtils;

public class EncryptUtils {

  public static String encrypt(String value) {
    return SecureUtil.md5(value);
  }

  public static boolean isEqual(String plainValue, String encryptedValue) {
    plainValue = encrypt(plainValue);
    return plainValue.equals(encryptedValue);
  }

  public static void main(String[] args) {}
}
